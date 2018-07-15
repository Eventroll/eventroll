package com.eventroll.common;

/**
 * Author: William Arustamyan
 * Date: 15/07/2018
 * Time: 1:00 PM
 */

public interface MultimediaEntity {

    String getName();

    String getDescription();

    MultimediaType getType();

    byte[] getData();
}
