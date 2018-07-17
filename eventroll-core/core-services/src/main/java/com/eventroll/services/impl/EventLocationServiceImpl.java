package com.eventroll.services.impl;

import com.eventroll.entity.EventLocation;
import com.eventroll.services.EventLocationService;
import org.springframework.stereotype.Service;

/**
 * Author: William Arustamyan
 * Date: 17/07/2018
 * Time: 10:00 PM
 */

@Service
public class EventLocationServiceImpl implements EventLocationService {

    @Override
    public EventLocation create(double latitude, double longitude) {
        final EventLocation instance = new EventLocation();

        instance.setLatitude(latitude);
        instance.setLongitude(longitude);

        //TODO: Resolve address.
        instance.setAddress("Some Resolved Address");
        return instance;
    }
}
