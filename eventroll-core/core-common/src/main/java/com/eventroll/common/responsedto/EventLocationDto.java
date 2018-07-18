package com.eventroll.common.responsedto;

/**
 * Author: William Arustamyan
 * Date: 18/07/2018
 * Time: 8:01 AM
 */

public class EventLocationDto {

    private double latitude;

    private double longitude;

    private String address;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
