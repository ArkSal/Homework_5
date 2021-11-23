package models;

import handlers.RandomDataProvider;
import handlers.UserInputHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieLibrary {
    private static List<Movie> moviesLibrary;

    public MovieLibrary(Movie[] movies) {
        moviesLibrary = new ArrayList<>(Arrays.asList(movies));
    }

    public MovieLibrary() {
    }

    public static List<Movie> getMoviesLibrary() {
        return moviesLibrary;
    }

    public void printMoviesInDateRange() {
        List<String> moviesInRangeList = getMovieTitlesInDateRange();
        if (moviesInRangeList.isEmpty()) {
            System.out.println("There is no movies in given date range");
        } else {
            System.out.println("Found " + moviesInRangeList.size() + " movies in a given range.");
            moviesInRangeList.stream()
                    .forEach(System.out::println);
        }
    }

    private List<String> getMovieTitlesInDateRange() {
        List<Date> dates = UserInputHandler.getDatesFromUser();
        return moviesLibrary.stream()
                .filter(s -> (s.getReleaseDate().equals((dates.get(0))) || s.getReleaseDate().after(dates.get(0)))
                        && (s.getReleaseDate().equals(dates.get(1))) || s.getReleaseDate().before(dates.get(1)))
                .map(Movie::getTitle)
                .collect(Collectors.toList());
    }

    public void getRandomMovieInformation() {
        System.out.println(moviesLibrary.get(RandomDataProvider.getRandomMovieIndex()));
    }

    public void printActorFilmography() {
        Actor actor = UserInputHandler.getActorFromUser();
        List<String> actorFilmographyList = getActorFilmographyList(actor);
        if (actorFilmographyList.isEmpty()) {
            System.out.println(actor + " didn't play in any movie from library.");
        } else {
            System.out.println("Actor " + actor + " have played in movies:");
            String separator = "";

            for (String movie : actorFilmographyList) {
                System.out.println(separator + movie);
                separator = ", ";
            }
        }
    }

    private List<String> getActorFilmographyList(Actor actorToFind) {
        Predicate<Movie> movieCheck = movie -> movie.getListOfActors().stream()
                .anyMatch(actor -> actor.getFirstName().equals(actorToFind.getFirstName()) &&
                        actor.getLastName().equals(actorToFind.getLastName()));

        return moviesLibrary.stream()
                .filter(movieCheck)
                .map(Movie::getTitle)
                .collect(Collectors.toList());
    }


}
