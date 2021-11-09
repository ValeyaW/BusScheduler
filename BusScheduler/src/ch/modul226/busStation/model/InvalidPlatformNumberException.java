package ch.modul226.busStation.model;

public class InvalidPlatformNumberException extends Exception {

    public InvalidPlatformNumberException(){
        super("Sorry- Diese Platformnummer gibt es nicht");
    }
}
