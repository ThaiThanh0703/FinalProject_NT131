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

public class BLEData_Adapter extends ArrayAdapter<DataDevice> {

    public BLEData_Adapter(Context context, ArrayList<DataDevice> dataBLE){
        super(context,0,dataBLE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View currentItemView=convertView;
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_ble_data, parent, false);
        }

        DataDevice currentNumberPosition= getItem(position);
        TextView tvtimeReceived = (TextView)
                currentItemView.findViewById(R.id.tvTimeReceived);
        TextView tvidData = (TextView)
                currentItemView.findViewById(R.id.tvIDData);
        TextView tvdistanceData = (TextView)
                currentItemView.findViewById(R.id.tvDistanceData);



        return currentItemView;
    }
}
