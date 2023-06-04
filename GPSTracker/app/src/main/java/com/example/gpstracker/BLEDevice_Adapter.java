package com.example.gpstracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class BLEDevice_Adapter extends ArrayAdapter<BLEDevice> {

    public BLEDevice_Adapter(Context context, ArrayList<BLEDevice> ble_Devices){
        super(context,0,ble_Devices);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View currentItemView=convertView;
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_ble_device, parent, false);
        }

        BLEDevice currentNumberPosition= getItem(position);
        TextView tvDevice_Name = (TextView)
                currentItemView.findViewById(R.id.item_bleDevice_name);
        Button btnConnect= (Button)
                currentItemView.findViewById(R.id.item_bthConnectBLEDevice);
        ConstraintLayout clParent= (ConstraintLayout)
                currentItemView.findViewById(R.id.item_nameDevice_cl_parent);

        if (currentNumberPosition.getBLEDeviceName()!=null) {
            tvDevice_Name.setText(currentNumberPosition.getBLEDeviceName());
        }
        else tvDevice_Name.setText("");

        return currentItemView;
    }
}
