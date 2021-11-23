package converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Movie;
import models.MovieLibrary;

import java.io.File;
import java.io.IOException;

public class JsonConverter {
    public static void JsonDeserialization() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src\\main\\resources\\Movies.json");
        try {
            new MovieLibrary(objectMapper.readValue(file, Movie[].class));
            System.out.println("JSON file read correctly");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
