package com.eventroll.common.requestdto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Author: William Arustamyan
 * Date: 17/07/2018
 * Time: 9:25 PM
 */

public class EventKeywordCreationRequest {

    @NotNull
    @NotBlank
    private String name;

    public EventKeywordCreationRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
