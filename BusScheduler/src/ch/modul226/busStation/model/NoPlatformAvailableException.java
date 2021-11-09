package ch.modul226.busStation.model;

public class NoPlatformAvailableException extends Exception {

    public NoPlatformAvailableException(){
        super("Sorry- Keine freie Platform gefunden");
    }
}
