package parkinglot.parkingmanager;
/**
 * @author: Subodh
 * @version: 1.1
 *
 * @file: Vehicle
 * @Descritption: This is an enum class which will contain different variety of
 * vehicle will be parked
 */
public enum Vehicle {
    TRUCK("Truck"),
    BIKE("Bike"),
    CAR("Car"),
    SUV("SUV"),
    BUS("Bus");

    private final String vehicle;
    Vehicle(String vehicle) {
        this.vehicle=vehicle;
    }

    public String getVehicle() {
        return vehicle;
    }
}
