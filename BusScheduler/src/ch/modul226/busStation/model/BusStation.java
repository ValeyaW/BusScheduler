package ch.modul226.busStation.model;

public class BusStation {

    private Platform[] platforms;
    private String name;

    public BusStation() {
        this.name = "Zurich";
        this.platforms = new Platform[10];
        //vier nationale Platformen
        platforms[0] = new NationalPlatform(1);
        platforms[1] = new NationalPlatform(2);
        platforms[2] = new NationalPlatform(3);
        platforms[3] = new NationalPlatform(4);

        //zwei kleine internationale Platformen
        platforms[4] = new InternationalPlatform(5, InternationalPlatform.SMALL);
        platforms[5] = new InternationalPlatform(6, InternationalPlatform.SMALL);

        //vier grosse internationale Platformen
        platforms[6] = new InternationalPlatform(7, InternationalPlatform.BIG);
        platforms[7] = new InternationalPlatform(8, InternationalPlatform.BIG);
        platforms[8] = new InternationalPlatform(9, InternationalPlatform.BIG);
        platforms[9] = new InternationalPlatform(10, InternationalPlatform.BIG);

    }

    public int arrive(Ride ride) throws NoPlatformAvailableException {
        Platform platform = searchFreePlatform(ride);
        platform.arrive(ride);
        return platform.getPlatformNumber();
    }

    private Platform searchFreePlatform(Ride ride) throws NoPlatformAvailableException {
        for (short i = 0; i < platforms.length; i++) {
            if (platforms[i].isFree()) {
                if (ride.isNational()) {
                    return platforms[i];
                }
            } else {
                if (platforms[i] instanceof InternationalPlatform && ((InternationalPlatform) platforms[i]).getSize() == InternationalPlatform.BIG
                        || ride.getBus().isBigspace()) {
                    return platforms[i];

                }
            }

        }
        throw new NoPlatformAvailableException();
    }

    public void departure(int platformNumber) {

    }

    public void platformStatus(int platformNumber) {

    }

    public Platform getPlatform(int platformNumber) throws InvalidPlatformNumberException{
        try{
            return platforms[platformNumber];
        }
        catch(ArrayIndexOutOfBoundsException ex){
            throw new InvalidPlatformNumberException();
        }
    }
}

