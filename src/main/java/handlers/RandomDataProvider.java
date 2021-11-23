package handlers;

import models.MovieLibrary;

import java.util.Random;

public class RandomDataProvider {
    static Random random = new Random();

    public static int getRandomMovieIndex() {
        return random.nextInt(MovieLibrary.getMoviesLibrary().size());
    }
}
