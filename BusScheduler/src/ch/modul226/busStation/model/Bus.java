package ch.modul226.busStation.model;

public class Bus {
    private int type;
    private String refuelingTime;
    private int capacity;

    public static final int PROP = 0;   //was machen damit?
    public static final int JET = 1;    //was machen damit?

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
