package com.goeuro.http;

import com.goeuro.exception.HttpResponseException;
import com.goeuro.model.Position;
import com.goeuro.util.PropertiesLoader;
import com.google.gson.Gson;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static java.lang.String.format;

/**
 * Created by sony on 3/22/2015.
 */
public class GoEuroHttpClient {
    private static final Logger logger = LoggerFactory.getLogger(GoEuroHttpClient.class);

    public Position[] getPosition(final StringBuilder location) throws HttpResponseException {
        if (StringUtils.isEmpty(location) || StringUtils.isBlank(location)) {
            throw new IllegalArgumentException("The location is empty or blank!");
        }
        String cleanLocation = location.toString().trim().replace(" ", "%20");  //added for location (string having spaces in between like new york
        final HttpClient client = new HttpClient();
        final String url = buildURL(cleanLocation);
        final HttpMethod method = new GetMethod(url);
        try {
            int status = client.executeMethod(method);
            if (status != HttpStatus.SC_OK) {
                final String msg = "An error occurred while executing GET to RESTFull API: %s";
                throw new HttpResponseException(format(msg, url), status);
            }
            final String response = method.getResponseBodyAsString();
            Position[] data = convert(response);
            return data;
        } catch (HttpException e) {
            logger.error("HttpException: {}", e.getMessage());
            throw new HttpResponseException(e.getMessage());
        } catch (IOException e) {
            logger.error("An IO exception was thrown with message: {}", e.getMessage());
            throw new HttpResponseException(e.getMessage());
        } finally {
            method.releaseConnection();
        }
    }

    private Position[] convert(final String response) {
        final Gson gson = new Gson();
        return gson.fromJson(response, Position[].class);
    }

    private String buildURL(final String location) {
        StringBuilder stringBuilder = new StringBuilder(PropertiesLoader.getURL());
        stringBuilder.append(location);
        return stringBuilder.toString();
    }
}
