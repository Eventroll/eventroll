package com.eventroll.common.requestdto;

import javax.validation.constraints.NotNull;

/**
 * Author: William Arustamyan
 * Date: 17/07/2018
 * Time: 9:19 PM
 */

public class EventLocationCreationRequest {

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    public EventLocationCreationRequest() {
        super();
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
