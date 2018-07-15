package com.eventroll.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: William Arustamyan
 * Date: 15/07/2018
 * Time: 11:21 AM
 */

@RestController
public class AppSettingsController {


    //TODO:resolve this with properties
    @RequestMapping("/version")
    public String version() {
        return "0.0.1";
    }
}
