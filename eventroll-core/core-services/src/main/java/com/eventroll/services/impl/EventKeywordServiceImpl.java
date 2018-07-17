package com.eventroll.services.impl;

import com.eventroll.common.requestdto.EventKeywordCreationRequest;
import com.eventroll.entity.Event;
import com.eventroll.entity.EventKeyword;
import com.eventroll.services.EventKeywordService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: William Arustamyan
 * Date: 17/07/2018
 * Time: 10:52 PM
 */

@Service
public class EventKeywordServiceImpl implements EventKeywordService {

    @Override
    public EventKeyword create(EventKeywordCreationRequest keywordRequest, Event event) {
        final EventKeyword instance = new EventKeyword();
        instance.setName(keywordRequest.getName());
        instance.setEvent(event);
        return instance;
    }

    @Override
    public Set<EventKeyword> bulkCreate(Set<EventKeywordCreationRequest> keywordsRequest, Event event) {
        final Set<EventKeyword> keywords = new HashSet<>(keywordsRequest.size());
        keywordsRequest.forEach(it -> keywords.add(this.create(it, event)));
        return keywords;
    }
}
