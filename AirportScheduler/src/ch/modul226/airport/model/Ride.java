package ch.modul226.airport.model;

public class Ride {
    private int nummer;
    private String startzeit;
    private String landezeit;
    private Flugzeug flugzeug;


    public boolean isNational() {
        return this.nummer < 1000;
    }

    public int getNummer(){
       return this.nummer;
    }

    public void setNummer(int newNummer){
        this.nummer = newNummer;
    }

    public String getStartzeit(){
        return this.startzeit;
    }
    public void setStartzeit(String newStartzeit){
        this.startzeit = newStartzeit;
    }

    public String getLandezeit(){
        return this.landezeit;
    }
    public void setLandezeit(String newLandezeit){
        this.landezeit = newLandezeit;
    }

    public Flugzeug getFlugzeug(){
        return this.flugzeug;
    }
    public void setFlugzeug(Flugzeug newFlugzeug){
        this.flugzeug = newFlugzeug;
    }

    public Flug(){

    }
}
