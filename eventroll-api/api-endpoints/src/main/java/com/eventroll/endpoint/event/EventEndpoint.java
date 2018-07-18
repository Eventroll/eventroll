package com.eventroll.endpoint.event;

import com.eventroll.common.requestdto.EventCreationRequest;
import com.eventroll.common.responsedto.AbstractResponse;
import com.eventroll.common.responsedto.EventResponseDto;
import com.eventroll.entity.Event;
import com.eventroll.services.EventService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Author: William Arustamyan
 * Date: 15/07/2018
 * Time: 3:19 PM
 */

@RestController
public class EventEndpoint {

    private static Logger logger = LoggerFactory.getLogger(EventEndpoint.class);

    @Autowired
    private EventService eventService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "/event/", method = RequestMethod.POST)
    public AbstractResponse<EventResponseDto> create(@RequestBody final EventCreationRequest creationRequest) {

        logger.info("Creating event with name for user : {}, with name {} ...", "SOME USER", creationRequest.getEventName());
        Event savedInstance = eventService.create(creationRequest);
        logger.info("Done creating event with id : {} ...", savedInstance.getId());

        return new AbstractResponse<>(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), modelMapper.map(savedInstance, EventResponseDto.class));
    }

    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public AbstractResponse<EventResponseDto> get(@PathVariable("id") long eventId) {

        logger.info("Retrieve single event for user {}, and event id {} ...", "SOME USER", eventId);
        Event foundInstance = eventService.get(eventId);
        logger.info("Done retrieving event with id : {} ...", foundInstance.getId());

        return new AbstractResponse<>(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), modelMapper.map(foundInstance, EventResponseDto.class));
    }

    @RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
    public AbstractResponse<Void> delete(@PathVariable("id") long eventId) {
        logger.info("Deleting event with id {}", eventId);
        eventService.delete(eventId);
        logger.info("Event with id {} deleted", eventId);
        return new AbstractResponse<>(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.name());
    }
}
