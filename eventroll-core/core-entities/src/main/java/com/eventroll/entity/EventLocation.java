package com.eventroll.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Author: William Arustamyan
 * Date: 15/07/2018
 * Time: 11:54 AM
 */

@Entity
@Table(name = "t_event_location")
public class EventLocation extends DefaultEntity {

    @Id
    @SequenceGenerator(name = "seq_event_location", sequenceName = "seq_event_location")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_event_location")
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "lat", nullable = false)
    private int latitude;

    @Column(name = "lon", nullable = false)
    private int longitude;

    @Column(name = "addr", nullable = false)
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        EventLocation eventLocation = (EventLocation) o;

        return new EqualsBuilder()
                .append(id, eventLocation.id)
                .append(latitude, eventLocation.latitude)
                .append(longitude, eventLocation.longitude)
                .append(address, eventLocation.address)
                .append(created, eventLocation.created)
                .append(updated, eventLocation.updated)
                .append(deleted, eventLocation.deleted)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(latitude)
                .append(longitude)
                .append(address)
                .append(created)
                .append(updated)
                .append(deleted)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("latitude", latitude)
                .append("longitude", longitude)
                .append("address", address)
                .append("created", created)
                .append("updated", updated)
                .append("deleted", deleted)
                .toString();
    }
}
