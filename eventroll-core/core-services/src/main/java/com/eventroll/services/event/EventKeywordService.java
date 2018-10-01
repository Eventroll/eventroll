package com.eventroll.services.event;

import com.eventroll.common.requestdto.event.EventKeywordCreationRequest;
import com.eventroll.entity.event.Event;
import com.eventroll.entity.event.EventKeyword;

import java.util.Set;

/**
 * Author: William Arustamyan
 * Date: 17/07/2018
 * Time: 10:51 PM
 */

public interface EventKeywordService {

    EventKeyword create(EventKeywordCreationRequest keywordRequest, Event event);

    Set<EventKeyword> bulkCreate(Set<EventKeywordCreationRequest> keywordsRequest, Event event);
}
