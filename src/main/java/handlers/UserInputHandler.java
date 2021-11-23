package handlers;

import models.Actor;
import models.MenuOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserInputHandler {
    static Scanner scanner = new Scanner(System.in);

    public static MenuOptions getMenuOptionFromUser() {
        return MenuOptions.values()[getSelectedOptionFromUser() - 1];
    }

    public static Actor getActorFromUser() {
        System.out.println("Type an actor: ");
        String[] actors = scanner.nextLine().split(" ");
        return new Actor(actors[0], actors[1]);
    }

    public static List<Date> getDatesFromUser() {
        System.out.println("Enter a dates range. Correct date format is yyyy-MM-dd:");
        System.out.println("Separate them with space.");
        String[] dates = scanner.nextLine().split(" ");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<Date> listOfDates = new ArrayList<>();
        try {
            listOfDates = List.of(formatter.parse(dates[0]), formatter.parse(dates[1]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return listOfDates;
    }

    private static int getSelectedOptionFromUser() {
        int result = getIntegerFromUser();
        scanner.nextLine();
        if (result > 0 && result < MenuOptions.values().length + 1) {
            return result;
        } else {
            System.out.println("You selected non exiting option: " + result);
            System.out.println("Please try again");
            return getSelectedOptionFromUser();
        }
    }

    private static int getIntegerFromUser() {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("It's not an integer number, try one more:");
        }
        return scanner.nextInt();
    }
}
