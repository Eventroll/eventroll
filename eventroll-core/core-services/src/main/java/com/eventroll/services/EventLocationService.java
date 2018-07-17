package com.eventroll.services;

import com.eventroll.entity.EventLocation;

/**
 * Author: William Arustamyan
 * Date: 17/07/2018
 * Time: 9:58 PM
 */

public interface EventLocationService {

    EventLocation create(double latitude, double longitude);
}
