package ch.modul226.busStation.model;

public class Bus {
    private int type;
    private String refuelingTime;
    private int capacity;

    public static final int ONESTORY = 0;
    public static final int TWOSTORY = 1;

    public Bus() {
    }

    public boolean isBigspace() {
        return capacity >= 200;
    }


    public int getType() {
        return this.type;
    }

    public int setType(int newType){
        return this.type = newType;
    }

    public String getRefuelingTime() {
        return this.refuelingTime;
    }

    public String setRefuelingTime(String newRefuelingTime){
        return this.refuelingTime = newRefuelingTime;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int setCapacity(int newCapacity){
        return this.capacity = newCapacity;
    }
}
