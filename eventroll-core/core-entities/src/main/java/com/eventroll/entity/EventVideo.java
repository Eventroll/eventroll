package com.eventroll.entity;

import com.eventroll.common.MultimediaEntity;
import com.eventroll.common.MultimediaType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Author: William Arustamyan
 * Date: 15/07/2018
 * Time: 12:50 PM
 */

@Entity
@Table(name = "t_event_video")
public class EventVideo extends DefaultEntity implements MultimediaEntity {


    @Id
    @SequenceGenerator(name = "seq_event_video", sequenceName = "seq_event_video")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_event_video")
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "dsc", nullable = false)
    private String description;

    @Column(name = "data")
    private byte[] videoData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getVideoData() {
        return videoData;
    }

    public void setVideoData(byte[] videoData) {
        this.videoData = videoData;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public MultimediaType getType() {
        return MultimediaType.VIDEO;
    }

    @Override
    public byte[] getData() {
        return this.videoData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        EventVideo eventVideo = (EventVideo) o;

        return new EqualsBuilder()
                .append(id, eventVideo.id)
                .append(name, eventVideo.name)
                .append(description, eventVideo.description)
                .append(event, eventVideo.event)
                .append(created, eventVideo.created)
                .append(updated, eventVideo.updated)
                .append(deleted, eventVideo.deleted)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(description)
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
                .append("description", description)
                .append("event", event)
                .append("created", created)
                .append("updated", updated)
                .append("deleted", deleted)
                .toString();
    }
}
