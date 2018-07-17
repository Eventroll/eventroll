package com.eventroll.common.requestdto;

import com.eventroll.common.CategoryType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Author: William Arustamyan
 * Date: 17/07/2018
 * Time: 9:18 PM
 */

public class EventCreationRequest {

    @NotNull
    @NotBlank
    private String eventName;

    @NotNull
    private EventLocationCreationRequest eventLocation;

    @NotNull
    private Set<EventKeywordCreationRequest> eventKeywords;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime startDate;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime endDate;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    private CategoryType categoryType;

    private Set<EventImageCreationRequest> eventImages;

    private Set<EventVideoCreationRequest> eventVideos;

    public EventCreationRequest() {
        super();
    }

    public String getEventName() {

        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public EventLocationCreationRequest getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(EventLocationCreationRequest eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Set<EventKeywordCreationRequest> getEventKeywords() {
        return eventKeywords;
    }

    public void setEventKeywords(Set<EventKeywordCreationRequest> eventKeywords) {
        this.eventKeywords = eventKeywords;
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

    public Set<EventImageCreationRequest> getEventImages() {
        return eventImages;
    }

    public void setEventImages(Set<EventImageCreationRequest> eventImages) {
        this.eventImages = eventImages;
    }

    public Set<EventVideoCreationRequest> getEventVideos() {
        return eventVideos;
    }

    public void setEventVideos(Set<EventVideoCreationRequest> eventVideos) {
        this.eventVideos = eventVideos;
    }
}
