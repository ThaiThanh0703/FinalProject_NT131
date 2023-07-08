package com.example.gpstracker;
import java.time.Instant;

public class Data_BLEDevice {

    private double latitude;
    private double longitude;
    private Instant timeReceived;

    public Data_BLEDevice(double lati, double longi,Instant time){
        this.latitude=lati;
        this.longitude=longi;
        this.timeReceived=time;
    }

    public void setDataBLE_Lati(double lati){this.latitude=lati;}
    public void setDataBLE_Longi(double longi){ this.longitude=longi;}
    public void setDataBLE_Time(Instant time){ this.timeReceived=time;}

    public double getBLEDeviceName(){return this.latitude;}
    public double getBLEDevice_Uuid(){return this.longitude;}
    public Instant getBLEDevice_Data(){return this.timeReceived;}

}
