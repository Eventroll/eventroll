package com.eventroll.services.impl;

import com.eventroll.common.requestdto.EventCreationRequest;
import com.eventroll.common.requestdto.EventModificationRequest;
import com.eventroll.entity.Event;
import com.eventroll.entity.EventLocation;
import com.eventroll.repositories.EventRepository;
import com.eventroll.services.EventKeywordService;
import com.eventroll.services.EventLocationService;
import com.eventroll.services.EventService;
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

        entityManager.flush();
        logger.info("Done saving event with id : {} ...", savedInstance.getId());

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
        logger.info("Event with id {} was deleted", found.getId());
    }
}
