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
public class EventLocation {

    @Id
    @SequenceGenerator(name = "seq_event_location", sequenceName = "seq_event_location")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_event_location")
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "lat", nullable = false)
    private double latitude;

    @Column(name = "lon", nullable = false)
    private double longitude;

    @Column(name = "addr", nullable = false)
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
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
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(latitude)
                .append(longitude)
                .append(address)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("latitude", latitude)
                .append("longitude", longitude)
                .append("address", address)
                .toString();
    }
}
