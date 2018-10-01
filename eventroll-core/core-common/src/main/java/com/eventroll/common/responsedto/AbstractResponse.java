package com.eventroll.common.responsedto;

/**
 * Author: William Arustamyan
 * Date: 17/07/2018
 * Time: 10:44 PM
 */

public class AbstractResponse<T> {

    private int statusCode;

    private String resultMessage;

    private T instance;

    public AbstractResponse(final int statusCode, final String resultMessage) {
        this.statusCode = statusCode;
        this.resultMessage = resultMessage;
    }

    public AbstractResponse(final int statusCode, final String resultMessage, T instance) {
        this(statusCode, resultMessage);
        this.instance = instance;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public T getInstance() {
        return instance;
    }

    public void setInstance(T instance) {
        this.instance = instance;
    }
}
