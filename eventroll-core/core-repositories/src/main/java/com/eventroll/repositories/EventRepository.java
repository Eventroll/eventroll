package com.eventroll.repositories;

import com.eventroll.entity.Event;
import org.springframework.data.repository.CrudRepository;

/**
 * Author: William Arustamyan
 * Date: 17/07/2018
 * Time: 9:54 PM
 */

public interface EventRepository extends CrudRepository<Event, Long> {


    Event findByIdAndDeletedIsNull(Long eventId);
}
