package ch.modul226.airport.model;

public class Flugzeug {
    private int typ;
    private String nachtankzeit;
    private int kapazitaet;

    public static final int PROP = 0;
    public static final int JET = 1;

    public Flugzeug() {
    }

    public boolean istGrossraum() {
        return kapazitaet >= 200;
    }


    public int getTyp() {
        return this.typ;
    }

    public int setTyp(int newTyp){
        return this.typ = newTyp;
    }

    public String getNachtankzeit() {
        return this.nachtankzeit;
    }

    public String setNachtankzeit(String newNachtankzeit){
        return this.nachtankzeit= newNachtankzeit;
    }

    public int getKapazitaet() {
        return this.kapazitaet;
    }

    public int setKapazitaet(int newKapazitaet){
        return this.kapazitaet = newKapazitaet;
    }
}
