package com.eventroll.entity;

import com.eventroll.common.CategoryType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Author: William Arustamyan
 * Date: 15/07/2018
 * Time: 11:53 AM
 */

@Entity
@Table(name = "t_event")
public class Event extends DefaultEntity {

    @Id
    @SequenceGenerator(name = "seq_event", sequenceName = "seq_event")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_event")
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @OneToOne
    @JoinColumn(name = "event_location_id", referencedColumnName = "id")
    private EventLocation eventLocation;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    @Where(clause = "\"deleted\" is null")
    private Set<EventKeyword> eventKeywords;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "dsc", nullable = false)
    private String description;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    @Where(clause = "\"deleted\" is null")
    private Set<EventImage> eventImages;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    @Where(clause = "\"deleted\" is null")
    private Set<EventVideo> eventVideos;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_type", nullable = false)
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

    public EventLocation getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(EventLocation eventLocation) {
        this.eventLocation = eventLocation;
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

    public Set<EventKeyword> getEventKeywords() {
        return eventKeywords;
    }

    public void setEventKeywords(Set<EventKeyword> eventKeywords) {
        this.eventKeywords = eventKeywords;
    }

    public Set<EventImage> getEventImages() {
        return eventImages;
    }

    public void setEventImages(Set<EventImage> eventImages) {
        this.eventImages = eventImages;
    }

    public Set<EventVideo> getEventVideos() {
        return eventVideos;
    }

    public void setEventVideos(Set<EventVideo> eventVideos) {
        this.eventVideos = eventVideos;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        return new EqualsBuilder()
                .append(id, event.id)
                .append(eventName, event.eventName)
                .append(startDate, event.startDate)
                .append(endDate, event.endDate)
                .append(description, event.description)
                .append(eventImages, event.eventImages)
                .append(eventVideos, event.eventVideos)
                .append(categoryType, event.categoryType)
                .append(created, event.created)
                .append(updated, event.updated)
                .append(deleted, event.deleted)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(eventName)
                .append(startDate)
                .append(endDate)
                .append(description)
                .append(eventImages)
                .append(eventVideos)
                .append(categoryType)
                .append(created)
                .append(updated)
                .append(deleted)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("eventName", eventName)
                .append("startDate", startDate)
                .append("endDate", endDate)
                .append("description", description)
                .append("eventImages", eventImages)
                .append("eventVideos", eventVideos)
                .append("categoryType", categoryType)
                .append("created", created)
                .append("updated", updated)
                .append("deleted", deleted)
                .toString();
    }

}
