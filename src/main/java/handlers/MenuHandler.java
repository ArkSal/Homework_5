package handlers;

public class MenuHandler {
    public static void print() {
        System.out.println("\nAvailable actions: \npress");
        System.out.println("1 - to display all movies within date range\n" +
                "2 - to display all information about random movie\n" +
                "3 - to display all movies when selected actor have played\n" +
                "4 - to shutdown");
        System.out.println("Choose your action:     ");
    }
}
