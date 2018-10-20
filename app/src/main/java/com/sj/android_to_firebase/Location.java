package com.sj.android_to_firebase;

public class Location {
    String pothole_id;
    String lati;
    String longi;
    public Location(){

    }

    public Location(String pothole_id,String longi,String lati) {
        this.longi = longi;
        this.lati = lati;
        this.pothole_id = pothole_id;
    }

    public String getPothole_id() {
        return pothole_id;
    }

    public String getLati() {
        return lati;
    }

    public String getLongi() {
        return longi;
    }
}
