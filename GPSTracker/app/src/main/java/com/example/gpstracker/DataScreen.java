package com.example.gpstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.time.Duration;
import java.time.LocalTime;

public class DataScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_screen);

        TextView tvDeviceName_connected=findViewById(R.id.tvBar);
        TextView tvTime_received=findViewById(R.id.tv2TimeReceived);
        TextView tvdataDistance=findViewById(R.id.tv2DistanceData);
        TextView tvdataID=findViewById(R.id.tv2IDData);




    }

    private BluetoothGattCallback gattCallback = new BluetoothGattCallback() {
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
        }

        @Override
        public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            // Xử lý sự kiện đọc đặc điểm BLE
            if (status == BluetoothGatt.GATT_SUCCESS) {
                byte[] data = characteristic.getValue();

            }
        }

        private BluetoothGatt bluetoothGatt = new BluetoothGatt; // Đối tượng BluetoothGatt đã kết nối và khám phá dịch vụ

        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString("00002a00-0000-1000-8000-00805f9b34fb")); // Lấy đối tượng dịch vụ BLE theo UUID

        BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString("00002a00-0000-1000-8000-00805f9b34fb")); // Lấy đối tượng đặc điểm BLE theo UUID

        private void displayGattServices(List<BluetoothGattService> gattServices) {
            if (gattServices == null) return;
            String uuid = null;

            ArrayList<HashMap<String, String>> gattServiceData =
                    new ArrayList<HashMap<String, String>>();
            ArrayList<ArrayList<HashMap<String, String>>> gattCharacteristicData
                    = new ArrayList<ArrayList<HashMap<String, String>>>();
            ArrayList<ArrayList<BluetoothGattCharacteristic>> mGattCharacteristics =
                    new ArrayList<ArrayList<BluetoothGattCharacteristic>>();

            // Loops through available GATT Services.
            for (BluetoothGattService gattService : gattServices) {
                HashMap<String, String> currentServiceData =
                        new HashMap<String, String>();
                uuid = gattService.getUuid().toString();
                currentServiceData.put(

                gattServiceData.add(currentServiceData);

                ArrayList<HashMap<String, String>> gattCharacteristicGroupData =
                        new ArrayList<HashMap<String, String>>();
                List<BluetoothGattCharacteristic> gattCharacteristics =
                        gattService.getCharacteristics();
                ArrayList<BluetoothGattCharacteristic> charas =
                        new ArrayList<BluetoothGattCharacteristic>();
                // Loops through available Characteristics.
                for (BluetoothGattCharacteristic gattCharacteristic :
                        gattCharacteristics) {
                    charas.add(gattCharacteristic);
                    HashMap<String, String> currentCharaData =
                            new HashMap<String, String>();
                    uuid = gattCharacteristic.getUuid().toString();

                    gattCharacteristicGroupData.add(currentCharaData);
                }
                mGattCharacteristics.add(charas);
                gattCharacteristicData.add(gattCharacteristicGroupData);
            }

        }

    };
};