package com.eventroll.endpoint.user;

import com.eventroll.common.requestdto.user.UserCreationRequest;
import com.eventroll.common.responsedto.AbstractResponse;
import com.eventroll.common.responsedto.user.UserResponseDto;
import com.eventroll.services.user.UserService;
import com.eventroll.entity.user.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Author: William Arustamyan
 * Date: 18/07/2018
 * Time: 8:58 AM
 */
@RestController
public class UserEndpoint {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public AbstractResponse<UserResponseDto> create(@RequestBody final UserCreationRequest creationRequest) {
        User savedInstance = userService.create(creationRequest);
        return new AbstractResponse<>(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), modelMapper.map(savedInstance, UserResponseDto.class));
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public AbstractResponse<UserResponseDto> get(@PathVariable("id") long eventId) {
        User foundInstance = userService.get(eventId);
        return new AbstractResponse<>(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), modelMapper.map(foundInstance, UserResponseDto.class));
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public AbstractResponse<Void> delete(@PathVariable("id") long eventId) {
        userService.delete(eventId);
        return new AbstractResponse<>(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.name());
    }
}
