package ch.modul226.busStation.model;

public class Ride {
    private int number;
    private String departureTime;
    private String arrivalTime;
    private Bus bus;


    public boolean isNational() {
        return this.number < 1000;
    }

    public int getNumber(){
       return this.number;
    }

    public void setNumber(int newNumber) {this.number = newNumber; }

    public String getDepartureTime(){
        return this.departureTime;
    }
    public void setDepartureTime(String newDepartureTime){
        this.departureTime = newDepartureTime;
    }

    public String getArrivalTime(){
        return this.arrivalTime;
    }
    public void setArrivalTime(String newArrivalTime){
        this.arrivalTime = newArrivalTime;
    }

    public Bus getBus(){
        return this.bus;
    }
    public void setBus(Bus newBus){
        this.bus = newBus;
    }

    public Ride(){

    }
}
