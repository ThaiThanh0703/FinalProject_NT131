package com.example.gpstracker;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class BletoothOff_Screen extends AppCompatActivity {

      private boolean check_BLEon= false;
      final private ActivityResultLauncher<Intent> enableBtLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()== Activity.RESULT_OK){
                        //
                        //Bluetooth is enabled, handle the success case
                        check_BLEon= true;

                    } else {
                        //Bluetooth is not enabled, handle the failure case
                        //
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);

        final Button btnOn = findViewById(R.id.bthBluetoothOn);

        final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


        btnOn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!mBluetoothAdapter.isEnabled()) {
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    enableBtLauncher.launch(enableBtIntent);
                   // startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
                       // Intent FindDevice_screen = new Intent(v.getContext(),FindDevice.class);
                    //    startActivity(FindDevice_screen);

                }


            }
           // Intent FindDevice_screen = new Intent(this.,FindDevice.class);
           // startActivity(FindDevice_screen);
        });

       // Intent FindDevice_screen = new Intent(this,FindDevice.class);
       // startActivity(FindDevice_screen);
        }



    }
