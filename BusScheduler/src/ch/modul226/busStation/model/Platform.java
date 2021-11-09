package ch.modul226.busStation.model;

public abstract class Platform {
    private int number;
    private Ride ride;

    public boolean isFree(){
        return(this.ride == null);
    }

    public Bus getBus(){
        if(this.ride == null){
            return null;
        }
        return ride.getBus();
    }
    public Platform(int number){
        this.number = number;

    }

    public void arrive(Ride ride){
        this.ride = ride;
    }

    public void departure(Ride ride){
        this.ride = null;
    }

    public int getRideNumber(){
        return number;
    }

    public Ride getRide(){
        return ride;
    }

    public int getPlatformNumber(){
        return this.number;
    }

    public abstract int getSize();



}
