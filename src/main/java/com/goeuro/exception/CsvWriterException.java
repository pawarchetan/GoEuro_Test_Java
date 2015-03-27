package com.goeuro.exception;

/**
 * Created by sony on 3/22/2015.
 */
public class CsvWriterException extends Exception {
    private static final long serialVersionUID = -7373766109698741236L;

    public CsvWriterException() {
        super();
    }

    public CsvWriterException(String message) {
        super(message);
    }
}