package parkinglot.tickethandler;
/**
 * @author: Subodh
 * @version: 1.1
 *
 * @file: Ticket
 * @Descritption: The ticket will be generated during parking and so it contains
 * the required logic in it.
 */

import parkinglot.parkingmanager.Spot;
import parkinglot.parkingmanager.Vehicle;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class Ticket {

    private final int id;
    private final Spot spot;
    private final Vehicle vehicle;

    private final String parkingLocation;

    private final long parkTime;

    public Ticket(final int id,Spot spot, Vehicle vehicle,String parkingLocation) {
        this.id = id;
        this.spot = spot;
        this.vehicle = vehicle;
        this.parkingLocation=parkingLocation;
        parkTime=System.currentTimeMillis();

    }

    public Integer getId() {
        return this.id;
    }

    public Spot getSpot() {
        return this.spot;
    }

    public String getVehicle() {
        return vehicle.getVehicle();
    }

    public String getParkingLocation() {
        return parkingLocation;
    }

    public long getParkTime() {
        return parkTime;
    }

    public int getDuration(){
        return (int) TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis()-parkTime);
    }

    @Override
    public String toString() {
        return "\n\n-:Parking Ticket ID:-"+id
                +"\n======================"
                +"\nVehicle: "+vehicle+
                "\nPark Location: "+parkingLocation+"\n\t\tParking time: "+ LocalDate.now();
    }
}
