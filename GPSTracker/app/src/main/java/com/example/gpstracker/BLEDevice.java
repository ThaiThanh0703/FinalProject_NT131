package com.example.gpstracker;

public class BLEDevice {
    private String Device_uuid;
    private String Device_name;
    private Boolean Device_isConnected;
    private String Device_data;

    public BLEDevice(String uuid, String name,Boolean connected,String data){
        this.Device_name=name;
        this.Device_isConnected=connected;
        this.Device_uuid=uuid;
        this.Device_data=data;
    }

    public void setBLEDevice_Name(String name){this.Device_name=name;}
    public void setBLEDevice_IsConnected(Boolean connected){this.Device_isConnected=connected;}
    public void setBLEDevice_Uuid(String uuid){this.Device_uuid=uuid;}
    public void setBLEDevice_Data(String data){this.Device_data=data;}

    public String getBLEDeviceName(){return this.Device_name;}
    public String getBLEDevice_Uuid(){return this.Device_uuid;}
    public String getBLEDevice_Data(){return this.Device_data;}
    public Boolean getIsPromotion(){return this.Device_isConnected;}


}
