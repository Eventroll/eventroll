package com.eventroll.services.event.impl;

import com.eventroll.common.requestdto.event.EventCreationRequest;
import com.eventroll.common.requestdto.event.EventModificationRequest;
import com.eventroll.entity.event.Event;
import com.eventroll.entity.event.EventLocation;
import com.eventroll.entity.user.User;
import com.eventroll.repositories.event.EventRepository;
import com.eventroll.services.event.EventKeywordService;
import com.eventroll.services.event.EventLocationService;
import com.eventroll.services.event.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Author: William Arustamyan
 * Date: 17/07/2018
 * Time: 9:53 PM
 */

@Service
public class EventServiceImpl implements EventService {

    private static Logger logger = LoggerFactory.getLogger(EventService.class);

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventLocationService eventLocationService;

    @Autowired
    private EventKeywordService eventKeywordService;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Event create(@NotNull final EventCreationRequest creationRequest) {
        final Event instance = new Event();

        instance.setEventName(creationRequest.getEventName());
        final EventLocation location =
                eventLocationService.create(creationRequest.getEventLocation().getLatitude(), creationRequest.getEventLocation().getLongitude());
        instance.setEventLocation(location);

        instance.setCategoryType(creationRequest.getCategoryType());
        instance.setDescription(creationRequest.getDescription());
        instance.setStartDate(creationRequest.getStartDate());
        instance.setEndDate(creationRequest.getEndDate());
        instance.setEventKeywords(eventKeywordService.bulkCreate(creationRequest.getEventKeywords(), instance));
        //TODO:Add image and video instances.

        Event savedInstance = eventRepository.save(instance);

        //TODO: Resolve user from security context and add to event.
//        instance.setUser(new User());

        entityManager.flush();

        return savedInstance;
    }

    @Override
    @Transactional(readOnly = true)
    public Event get(final long eventId) {
        //TODO: Handle event not found case. And exceptional cases.
        return eventRepository.findByIdAndDeletedIsNull(eventId);
    }

    @Override
    public Event update(@NotNull EventModificationRequest modificationRequest) {
        return null;
    }

    @Override
    @Transactional
    public void delete(final long eventId) {
        Event found = this.get(eventId);
        found.setDeleted(LocalDateTime.now());
        eventRepository.save(found);
    }
}
