package ch.modul226.airport.model;

public class NoGateAvailableException extends Exception {

    public NoGateAvailableException(){
        super("Sorry- Kein freies Gate gefunden");
    }
}
