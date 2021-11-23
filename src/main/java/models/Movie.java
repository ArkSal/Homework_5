package models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Movie {
    private String title;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date releaseDate;
    private Director director;
    private String genre;
    private List<Actor> listOfActors;

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public List<Actor> getListOfActors() {
        return listOfActors;
    }

    public String getGenre() {
        return genre;
    }

    public Director getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "title: " + title +
                "\ndirector: " + director +
                "\ngenre: " + genre +
                "\ndate: " + new SimpleDateFormat("yyyy-MM-dd").format(releaseDate) +
                "\nactors: " + printActorsInOneRow();
    }

    private String printActorsInOneRow() {
        var actorsInRow = new StringBuilder();
        String separator = "";
        for (Actor listOfActor : listOfActors) {
            actorsInRow.append(separator + listOfActor + "");
            separator = ", ";
        }
        return actorsInRow.toString();
    }
}
