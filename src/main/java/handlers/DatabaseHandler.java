package handlers;

import converters.JsonConverter;

public class DatabaseHandler {
    public static void readMoviesFromJSONFile() {
        System.out.println("Running MovieLibrary application.");
        JsonConverter.JsonDeserialization();
    }
}
