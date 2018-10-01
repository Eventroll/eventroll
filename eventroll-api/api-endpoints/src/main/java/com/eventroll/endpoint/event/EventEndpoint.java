package com.eventroll.endpoint.event;

import com.eventroll.common.requestdto.event.EventCreationRequest;
import com.eventroll.common.responsedto.AbstractResponse;
import com.eventroll.common.responsedto.event.EventResponseDto;
import com.eventroll.entity.event.Event;
import com.eventroll.services.event.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: William Arustamyan
 * Date: 15/07/2018
 * Time: 3:19 PM
 */

@Api(value = "Event CRUD endpoint ... ")
@RestController
public class EventEndpoint {

    private static Logger logger = LoggerFactory.getLogger(EventEndpoint.class);

    @Autowired
    private EventService eventService;

    @Autowired
    private ModelMapper modelMapper;

    @ApiOperation(value = "Create event ... ")
    @RequestMapping(value = "/event/", method = RequestMethod.POST)
    public AbstractResponse<EventResponseDto> create(@RequestBody final EventCreationRequest creationRequest) {
        Event savedInstance = eventService.create(creationRequest);
        return new AbstractResponse<>(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), modelMapper.map(savedInstance, EventResponseDto.class));
    }

    @ApiOperation(value = "Get event with id ... ")
    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public AbstractResponse<EventResponseDto> get(@PathVariable("id") long eventId) {
        Event foundInstance = eventService.get(eventId);
        return new AbstractResponse<>(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), modelMapper.map(foundInstance, EventResponseDto.class));
    }

    @ApiOperation(value = "Delete event by id ...")
    @RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
    public AbstractResponse<Void> delete(@PathVariable("id") long eventId) {
        eventService.delete(eventId);
        return new AbstractResponse<>(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.name());
    }
}
