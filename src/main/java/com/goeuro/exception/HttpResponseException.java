package com.goeuro.exception;

/**
 * Created by sony on 3/22/2015.
 */
public class HttpResponseException extends Exception {
    private static final long serialVersionUID = 112341241L;
    private int statusCode = 200;

    public HttpResponseException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpResponseException(String message) {
        super(message);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
