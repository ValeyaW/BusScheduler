package ch.modul226.busStation.model;

public class InternationalPlatform extends Platform {

    public static final int SMALL = 0;
    public static final int BIG = 1;

    private int size;

    public InternationalPlatform(int number, int size){
        super(number);
        this.size = size;
    }
    @Override
    public int getSize(){
        return this.size;
    }
}
