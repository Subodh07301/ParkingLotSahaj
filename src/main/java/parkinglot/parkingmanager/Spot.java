package parkinglot.parkingmanager;
/**
 * @author: Subodh
 * @version: 1.1
 *
 * @file: Spot
 * @Descritption: This maintains the spot for parking and which vehicle is parked
 */

public class Spot {

    private Vehicle carType;

    public Spot(final Vehicle carType) {
        this.carType = carType;
    }

    public Vehicle getCarType() {
        return carType;
    }

}
