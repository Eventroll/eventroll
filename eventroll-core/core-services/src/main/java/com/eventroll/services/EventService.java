package com.eventroll.services;

import com.eventroll.common.requestdto.EventCreationRequest;
import com.eventroll.common.requestdto.EventModificationRequest;
import com.eventroll.entity.Event;

import javax.validation.constraints.NotNull;

/**
 * Author: William Arustamyan
 * Date: 17/07/2018
 * Time: 9:50 PM
 */

public interface EventService {

    Event create(@NotNull EventCreationRequest creationRequest);

    Event get(long eventId);

    Event update(@NotNull EventModificationRequest modificationRequest);

    void delete(long eventId);
}
