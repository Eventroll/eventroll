package com.eventroll.services.event;

import com.eventroll.entity.event.EventLocation;

/**
 * Author: William Arustamyan
 * Date: 17/07/2018
 * Time: 9:58 PM
 */

public interface EventLocationService {

    EventLocation create(double latitude, double longitude);
}
