package parkinglot.parkingmanager;

/**
 * @author: Subodh
 * @version: 1.1
 *
 * @file: ParkingLotHandler
 * @Descritption: This file contains the logic for managing different lots for parking
 * and keep the logic for park and unpark.This will create a ticket during park
 * and generate a charge receipt during unpark
 */
import parkinglot.tickethandler.Receipt;
import parkinglot.tickethandler.Ticket;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;
public class ParkingLotHandler {

    //Declare the parking spot
    private final Set<Spot> spots;

    //Declare the sequence no which will track to create ticket id
    private Integer parkingSequenceNumber = 0;

    //Declare the receipt
    private Receipt receipt;

    //Initialize spots and receipt
    private ParkingLotHandler(Set<Spot> spots) {
        this.spots = spots;
        this.receipt = new Receipt();
    }

    //Will return total Spot available
    public Integer totalSpotCount() {
        return this.spots.size();
    }

    //Handle the parking of vehicle to Parking location like Airport,Stadium,Mall etc.
    //and generate ticket
    public Ticket park(@NotNull(message="Vehicle should not be null")
                       @NotEmpty(message="Vehicle should not be empty") final Vehicle vehicle,
                       String parkingLocation) {
        //Set Parking location as basic if it is not specified
        if(parkingLocation==null||parkingLocation.equals("")){
            parkingLocation="Base";
        }

        Spot selectedSpot = null;
        for (Spot spot : spots) {
            if (spot.getCarType() == vehicle) {
                selectedSpot = spot;
            }
        }

        if (selectedSpot != null) spots.remove(selectedSpot);
        return new Ticket(parkingSequenceNumber++, selectedSpot, vehicle,parkingLocation);
    }

    //Wrapper to park when parking location is not specified
    public Ticket park(@NotNull(message="Vehicle should not be null")
                       @NotEmpty(message="Vehicle should not be empty") final Vehicle vehicle){
        return park(vehicle,"Base");
    }

    //Will handle unpark and generate Receipt charges for unparking
    public String unPark(@NotNull(message = "There must be a ticket to unpark") final Ticket ticket) {
        spots.add(ticket.getSpot());
        return receipt.generateReceipt(ticket);
    }

    //Builder class will build the parking spot and build the parking strategy
    public static class Builder {

        public static final int DEFAULT_SPOT_COUNT = 10;
        private Integer smallParkingSpotCount = DEFAULT_SPOT_COUNT;
        private Integer mediumParkingSpotCount = DEFAULT_SPOT_COUNT;
        private Integer largeParkingSpotCount = DEFAULT_SPOT_COUNT;

        public Builder withSmallSpots(Integer count) {
            this.smallParkingSpotCount = count;
            return this;
        }

        public Builder withMediumSpots(Integer count) {
            this.mediumParkingSpotCount = count;
            return this;
        }

        public Builder withLargeSpots(Integer count) {
            this.largeParkingSpotCount = count;
            return this;
        }

        public ParkingLotHandler build() {
            Set<Spot> spots = new HashSet<>();
            spots.addAll(IntStream.range(0, this.smallParkingSpotCount).mapToObj(i -> new Spot(Vehicle.BIKE)).collect(toSet()));
            spots.addAll(IntStream.range(0, this.mediumParkingSpotCount).mapToObj(i -> new Spot(Vehicle.CAR)).collect(toSet()));
            spots.addAll(IntStream.range(0, this.largeParkingSpotCount).mapToObj(i -> new Spot(Vehicle.TRUCK)).collect(toSet()));
            return new ParkingLotHandler(spots);
        }

    }
}
