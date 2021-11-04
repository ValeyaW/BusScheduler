package ch.modul226.airport.view;

import ch.modul226.airport.utils.ConsoleReader;

import ch.modul226.airport.model.*;

public class Hauptmenue {
    private Flughafen flughafen = new Flughafen();

    public Hauptmenue(){

    }

    public static void main(String[] args) {
        Hauptmenue menue = new Hauptmenue();

        while(menue.aktion()) {

        }
        System.out.println();
        System.out.println(" Besten Dank und auf Wiedersehen");

    }

    private void anzeigen() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Airport Scheduler Hauptmenu");
        System.out.println("===========================");
        System.out.println();
        System.out.println("1 Landen");
        System.out.println("2 Starten");
        System.out.println("3 Gatedaten");
        System.out.println();
        System.out.println("4 Ende");
    }

    private void landen() {
        System.out.println("\n\n\nLanden...\n\n");
        Flug flug = flugDatenBeschaffen();
        try {
            int gateNummer = flughafen.landen(flug);
            System.out.println("Maschine ist an Gate " + gateNummer + " gelandet");
        } catch (NoGateAvailableException ex
        ) {
            System.out.println(ex.getMessage());
        }
    }
    private void starten(){
        System.out.println("\n\n\nstarten...\n\n");
        int gateNummer = ConsoleReader.readInteger("Gatenummer eingeben");
        try {
            Gate gate = flughafen.getGate(gateNummer);
            if (gate.istFrei()) {
                System.out.println("Das Gate ist nicht belegt, es gibt nichts zu starten!");
            }
            else {
                System.out.println("Take-off Flug " + gate.getFlug().getNummer());
            }
        }
        catch (InvalidGateNumberException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void gateDatenAnzeigen(){
        System.out.println("\n\nGate Daten anzeigen...\n\n");
        int gateNummer = ConsoleReader.readInteger("Gatenummer eingeben");
        try{
            Gate gate = flughafen.getGate(gateNummer);
            if(gate.istFrei()){
                System.out.println("Gate ist frei\n\n\n");
                return ;
            }
            if (gate instanceof NationalesGate){
                System.out.println("Nationales Gate");
                System.out.println("---------------");
            }
            else{
                System.out.println("Internationales Gate");
                System.out.println("---------------");
                System.out.println(gate.getGroesse() == InternationalesGate.GROSS ? "Grosses Gate" : "kleines Gate");
            }
            System.out.println("Flugnummer: " + gate.getFlug().getNummer());
            System.out.println("Flugzeugtyp" + (gate.getFlugzeug().getTyp() == Flugzeug.JET ? "Jet" : "prop"));
        }
        catch(InvalidGateNumberException ex){
            System.out.println(ex.getMessage());
        }
    }
    public boolean aktion(){
        while(true){
            this.anzeigen();
            int eingabe = ConsoleReader.readInteger("Ihre Wahl");
            switch(eingabe){
                case 1 :
                    landen();
                    return true;
                case 2 :
                    starten();
                    return true;
                case 3:
                    gateDatenAnzeigen();
                    return true;
                case 4:
                    return false;
                default :
                    System.out.println("Ungueltige Wahl");
            }
        }
    }

    private Flug flugDatenBeschaffen(){
        Flug flug = new Flug();
        System.out.println();
        System.out.println();
        System.out.println("Bitte Flugdaten eingeben");
        System.out.println("------------------------");
        flug.setNummer(ConsoleReader.readInteger("Flugnummer"));
        flug.setLandezeit(ConsoleReader.readString("Landezeit"));
        flug.setStartzeit(ConsoleReader.readString("Startzeit"));
        flug.setFlugzeug(flugzeugDatenBeschaffen());
        return flug;
    }

    private Flugzeug flugzeugDatenBeschaffen(){
        Flugzeug flugzeug = new Flugzeug();
        flugzeug.setTyp(ConsoleReader.readInteger("Flugzeugtyp (0=Prop, 1=Jet)"));
        flugzeug.setKapazitaet(ConsoleReader.readInteger("Passagierzahl"));
        flugzeug.setNachtankzeit(ConsoleReader.readString("Nachtankzeit"));
        return flugzeug;
    }

}

