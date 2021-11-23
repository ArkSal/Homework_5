import handlers.DatabaseHandler;
import handlers.MenuHandler;
import handlers.UserInputHandler;
import models.MovieLibrary;

public class MovieLibraryApp {
    public static void main(String[] args) {
        MovieLibrary movieLibrary = new MovieLibrary();
        DatabaseHandler.readMoviesFromJSONFile();

        while (true) {
            MenuHandler.print();
            System.out.println("\nEnter action: ");

            switch (UserInputHandler.getMenuOptionFromUser()) {
                case DISPLAYMOVIERWITHINRANGE:
                    movieLibrary.printMoviesInDateRange();
                    break;
                case DISPLAYINFORMATIONABOUTRANDOMMOVIE:
                    movieLibrary.getRandomMovieInformation();
                    break;

                case DISPLAYACTORMOVIES:
                    movieLibrary.printActorFilmography();
                    break;

                case QUIT:
                    System.out.println("\nQuiting...");
                    System.exit(1);
            }
        }
    }
}
