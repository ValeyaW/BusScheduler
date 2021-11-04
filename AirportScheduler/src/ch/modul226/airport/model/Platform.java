package ch.modul226.airport.model;

public abstract class Gate {
    private int nummer;
    private Flug flug;

    public boolean istFrei(){
        return(this.flug == null);
    }

    public Flugzeug getFlugzeug(){
        if(this.flug == null){
            return null;
        }
        return flug.getFlugzeug();
    }
    public Gate(int nummer){
        this.nummer = nummer;

    }

    public void landen(Flug flug){
        this.flug = flug;
    }

    public void starten(Flug flug){
        this.flug = null;
    }

    public int getFlugnummer(){
        return nummer;
    }

    public Flug getFlug(){
        return flug;
    }

    public int getGateNummer(){
        return this.nummer;
    }

    public abstract int getGroesse();



}
