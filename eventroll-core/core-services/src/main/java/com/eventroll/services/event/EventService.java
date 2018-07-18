package com.eventroll.services.event;

import com.eventroll.common.requestdto.event.EventCreationRequest;
import com.eventroll.common.requestdto.event.EventModificationRequest;
import com.eventroll.entity.event.Event;

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
