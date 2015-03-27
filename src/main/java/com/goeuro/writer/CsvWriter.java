package com.goeuro.writer;

import com.goeuro.exception.CsvWriterException;
import com.goeuro.model.GeoPosition;
import com.goeuro.model.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.format;

/**
 * Created by sony on 3/22/2015.
 */
public class CsvWriter {

    private final static Logger logger = LoggerFactory.getLogger(CsvWriter.class);
    private static StringBuilder FILE_NAME = new StringBuilder();

    public static void writeToCsv(final Position[] response, StringBuilder location) throws CsvWriterException {
        if (response == null || response.length == 0) {
            logger.warn("No positions were retrieved! Abort generating the CSV file");
            return;
        }
        try {
            FILE_NAME.append(System.getProperty("user.home") + "/" + location + "_" + new SimpleDateFormat("yyyyMMddhhmm").format(new Date()) + ".csv");
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(FILE_NAME.toString()), "UTF-8");

            writer.append("_id");
            writer.append(",");
            writer.append("name");
            writer.append(",");
            writer.append("type");
            writer.append(",");
            writer.append("latitude");
            writer.append(",");
            writer.append("longitude");
            writer.append("\n");

            for (int i = 0; i < response.length; i++) {
                Position position = response[i];
                writer.append(Integer.toString(position.getId()));
                writer.append(",");
                writer.append(position.getName());
                writer.append(",");
                writer.append(position.getType());
                writer.append(",");
                GeoPosition geoPosition = position.getGeoPosition();
                writer.append(Double.toString(geoPosition.getLatitude()));
                writer.append(",");
                writer.append(Double.toString(geoPosition.getLongitude()));
                writer.append("\n");
            }

            writer.flush();
            writer.close();

        } catch (IOException e) {
            logger.error("An IO exception has been thrown with message: {}", e.getMessage());
            throw new CsvWriterException(format("An IO exception has been thrown with message: %s",
                    e.getMessage()));
        }
    }
}
