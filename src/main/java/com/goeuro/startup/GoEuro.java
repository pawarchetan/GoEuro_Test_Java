package com.goeuro.startup;

import com.goeuro.exception.CsvWriterException;
import com.goeuro.exception.HttpResponseException;
import com.goeuro.http.GoEuroHttpClient;
import com.goeuro.model.Position;
import com.goeuro.writer.CsvWriter;

/**
 * Created by sony on 3/22/2015.
 */
public class GoEuro {

    public static void main(String[] args) throws HttpResponseException, CsvWriterException {
        if (args.length == 0) {
            System.err.println("Please enter Location!");
            printUsage();
        } else {
            StringBuilder inputCity = new StringBuilder();
            System.out.println("Note : \n" +
                    "1. Resultant CSV file will get created in your users directory present in C drive.Like:C:\\Users\\sony\\yourCsvFileName.\n"+
                    "2. Resultant CSV file get generate with name Location you provided and Date and Time. Like If you provide location as New York so\n"+
                    "   file will have name :- New York_201503221206.csv");
            inputCity.append(args[0]);
            for (int i = 1; i < args.length; i++) {
                inputCity.append(" " + args[i]);
            }

            Position[] response = new GoEuroHttpClient().getPosition(inputCity);
            CsvWriter.writeToCsv(response, inputCity);
        }
    }

    private static void printUsage() {
        System.err.println("Usage: Please enter city name");
        System.exit(1);
    }
}
