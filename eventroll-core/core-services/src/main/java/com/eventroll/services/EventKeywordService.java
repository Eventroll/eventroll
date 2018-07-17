package com.eventroll.services;

import com.eventroll.common.requestdto.EventKeywordCreationRequest;
import com.eventroll.entity.Event;
import com.eventroll.entity.EventKeyword;

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
