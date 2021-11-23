package models;

public enum MenuOptions {
    DISPLAYMOVIERWITHINRANGE(1),
    DISPLAYINFORMATIONABOUTRANDOMMOVIE(2),
    DISPLAYACTORMOVIES(3),
    QUIT(4);

    int action;

    MenuOptions(int action) {
        this.action = action;
    }
}
