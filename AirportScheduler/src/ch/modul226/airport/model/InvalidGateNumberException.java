package ch.modul226.airport.model;

public class InvalidGateNumberException extends Exception {

    public InvalidGateNumberException(){
        super("Sorry- Diese Gatenummer gibt es nicht");
    }
}
