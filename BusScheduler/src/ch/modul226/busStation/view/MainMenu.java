package ch.modul226.busStation.view;

import ch.modul226.busStation.utils.ConsoleReader;

import ch.modul226.busStation.model.*;

public class MainMenu {
    private BusStation busStation = new BusStation();

    public MainMenu(){

    }

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();

        while(menu.action()) {

        }
        System.out.println();
        System.out.println(" Besten Dank und auf Wiedersehen");

    }

    private void show() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Busfahrplan Hauptmenü");
        System.out.println("===========================");
        System.out.println();
        System.out.println("1 Ankommen");
        System.out.println("2 Abfahren");
        System.out.println("3 Platformdaten");
        System.out.println();
        System.out.println("4 Ende");
    }

    private void arrive() {
        System.out.println("\n\n\nAnkommen...\n\n");
        Ride ride = procureRideData();
        try {
            int platformNumber = busStation.arrive(ride);
            System.out.println("Bus ist an Platform " + platformNumber + " angekommen");
        } catch (NoPlatformAvailableException ex
        ) {
            System.out.println(ex.getMessage());
        }
    }
    private void departure(){
        System.out.println("\n\n\nstarten...\n\n");
        int platformNumber = ConsoleReader.readInteger("Platformnummer eingeben");
        try {
            Platform platform = busStation.getPlatform(platformNumber);
            if (platform.isFree()) {
                System.out.println("Die Platform ist nicht belegt, es gibt nichts zu starten!");
            }
            else {
                System.out.println("Abfahrt Fahrt " + platform.getRide().getNumber());
            }
        }
        catch (InvalidPlatformNumberException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void showPlatformData(){
        System.out.println("\n\nPlatformdaten anzeigen...\n\n");
        int platformNumber = ConsoleReader.readInteger("Platformnummer eingeben");
        try{
            Platform platform = busStation.getPlatform(platformNumber);
            if(platform.isFree()){
                System.out.println("Platform ist frei\n\n\n");
                return ;
            }
            if (platform instanceof NationalPlatform){
                System.out.println("Nationale Platform");
                System.out.println("---------------");
            }
            else{
                System.out.println("Internationale Platform");
                System.out.println("---------------");
                System.out.println(platform.getSize() == InternationalPlatform.BIG ? "Grosse Platform" : "kleine Platform");
            }
            System.out.println("Fahrtennummer: " + platform.getRide().getNumber());
            System.out.println("Bustyp" + (platform.getBus().getType() == Bus.TWOSTORY ? "Zweistöckig" : "Einstöckig"));
        }
        catch(InvalidPlatformNumberException ex){
            System.out.println(ex.getMessage());
        }
    }
    public boolean action(){
        while(true){
            this.show();
            int entry = ConsoleReader.readInteger("Ihre Wahl");
            switch(entry){
                case 1 :
                    arrive();
                    return true;
                case 2 :
                    departure();
                    return true;
                case 3:
                    showPlatformData();
                    return true;
                case 4:
                    return false;
                default :
                    System.out.println("Ungueltige Wahl");
            }
        }
    }

    private Ride procureRideData(){
        Ride ride = new Ride();
        System.out.println();
        System.out.println();
        System.out.println("Bitte Fahrtendaten eingeben");
        System.out.println("------------------------");
        ride.setNumber(ConsoleReader.readInteger("Fahrtennummer"));
        ride.setArrivalTime(ConsoleReader.readString("Ankunftszeit"));
        ride.setDepartureTime(ConsoleReader.readString("Abfahrtszeit"));
        ride.setBus(procureBusData());
        return ride;
    }

    private Bus procureBusData(){
        Bus bus = new Bus();
        bus.setType(ConsoleReader.readInteger("Bustyp (0=Einstöckig, 1=Zweistöckig)"));
        bus.setCapacity(ConsoleReader.readInteger("Passagierzahl"));
        bus.setRefuelingTime(ConsoleReader.readString("Nachtankzeit"));
        return bus;
    }

}

