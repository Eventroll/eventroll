package com.eventroll.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Author: William Arustamyan
 * Date: 15/07/2018
 * Time: 12:37 PM
 */

@Entity
@Table(name = "t_event_keyword")
public class EventKeyword {


    @Id
    @SequenceGenerator(name = "seq_event_key", sequenceName = "seq_event_key")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_event_key")
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore //TODO: Remove in feature, resolve with response DTO. Currently added to avoid Infinite recursion (StackOverflowError)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

    @Column(name = "deleted", nullable = true)
    private LocalDateTime deleted;

    @PrePersist
    protected void onCreate() {
        this.created = LocalDateTime.now();
        this.updated = this.created;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getDeleted() {
        return deleted;
    }

    public void setDeleted(LocalDateTime deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        EventKeyword eventKeyword = (EventKeyword) o;

        return new EqualsBuilder()
                .append(id, eventKeyword.id)
                .append(name, eventKeyword.name)
                .append(event, eventKeyword.event)
                .append(created, eventKeyword.created)
                .append(updated, eventKeyword.updated)
                .append(deleted, eventKeyword.deleted)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(event)
                .append(created)
                .append(updated)
                .append(deleted)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("event", event)
                .append("created", created)
                .append("updated", updated)
                .append("deleted", deleted)
                .toString();
    }

}
