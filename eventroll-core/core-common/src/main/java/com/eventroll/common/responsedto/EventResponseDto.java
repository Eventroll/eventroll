package com.eventroll.common.responsedto;

import com.eventroll.common.CategoryType;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Author: William Arustamyan
 * Date: 18/07/2018
 * Time: 7:59 AM
 */

public class EventResponseDto {

    private Long id;

    private String eventName;

    private EventLocationDto location;

    private Set<EventKeywordDto> keywords;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String description;

    private CategoryType categoryType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public EventLocationDto getLocation() {
        return location;
    }

    public void setLocation(EventLocationDto location) {
        this.location = location;
    }

    public Set<EventKeywordDto> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<EventKeywordDto> keywords) {
        this.keywords = keywords;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }
}
