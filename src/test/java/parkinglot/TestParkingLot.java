package parkinglot;
/**
 * @author: Subodh
 * @version: 1.1
 *
 * @file: ParkingLotTest
 * @Descritption: This is a test class which will check testing to park
 * vehicle for different location with different use cases.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parkinglot.parkingexception.ParkingExcption;
import parkinglot.parkingmanager.ParkingLotHandler;
import parkinglot.tickethandler.Ticket;
import parkinglot.parkingmanager.Vehicle;
import parkinglot.tickethandler.Receipt;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingLotTest {

    private ParkingLotHandler.Builder parkingLotBuilder;

    @BeforeEach
    void setUp() {
        this.parkingLotBuilder = new ParkingLotHandler.Builder().withLargeSpots(2).withMediumSpots(5).withSmallSpots(10);
    }

    @Test
    void shouldAllocateParkingSpotAndReturnTicketForACarWhenSpotAvailable() {
        ParkingLotHandler parkingLot = this.parkingLotBuilder.build();
        Vehicle car = Vehicle.CAR;
        Ticket ticket = parkingLot.park(car);

        assertEquals(0, ticket.getId());
    }

    @Test
    void shouldUnParkAParkedCarFromAGivenTicket() {
        ParkingLotHandler parkingLot = this.parkingLotBuilder.build();
        Vehicle car = Vehicle.CAR;
        Ticket ticket = parkingLot.park(car);
        assertEquals(car.getVehicle(), Receipt.forVehicle(ticket));
    }

    @Test
    void shouldTrackSpotOccupancyByVehicleType() {
        ParkingLotHandler parkingLot = this.parkingLotBuilder.withMediumSpots(1).withSmallSpots(1).build();
        Vehicle car = Vehicle.CAR;
        Vehicle bike = Vehicle.BIKE;
        Vehicle truck = Vehicle.TRUCK;

        assertEquals(0, parkingLot.park(car).getId());
        assertEquals(1, parkingLot.park(bike).getId());
        assertEquals(2, parkingLot.park(truck).getId());
    }

    @Test
    void shouldUnParkAndUnParkFixedNumberOfCars() {
        ParkingLotHandler parkingLot = this.parkingLotBuilder.withMediumSpots(3).withSmallSpots(0).withLargeSpots(0).build();

        Ticket ticketOne = parkingLot.park(Vehicle.CAR);
        Ticket ticketTwo = parkingLot.park(Vehicle.CAR);
        Ticket ticketThree = parkingLot.park(Vehicle.CAR);

        parkingLot.unPark(ticketOne);
        parkingLot.unPark(ticketOne);
        parkingLot.unPark(ticketTwo);
        parkingLot.unPark(ticketThree);

        assertEquals(3, parkingLot.totalSpotCount());
    }

    @Test
    void shouldGenerateReceiptWithFlatFeeByVehicleTypeOnUnPark() throws ParkingExcption {
        ParkingLotHandler parkingLot = this.parkingLotBuilder.build();
        Vehicle car = Vehicle.CAR;
        Ticket ticket = parkingLot.park(car);
        assertEquals(60, Receipt.getCharges(ticket));
    }

    @Test
    void shouldApplyFlatRateMultiplierAcrossAllVehicleTypes() throws ParkingExcption {
        ParkingLotHandler parkingLot = this.parkingLotBuilder.build();
        Vehicle car = Vehicle.CAR;
        Vehicle bike = Vehicle.BIKE;
        Vehicle truck = Vehicle.TRUCK;

        Ticket ticket_car=parkingLot.park(car);
        Ticket ticket_truck=parkingLot.park(truck);
        Ticket ticket_bike=parkingLot.park(bike);

        assertEquals(Receipt.getCharges(ticket_bike) * 4,Receipt.getCharges(ticket_truck)*2);
        assertEquals(Receipt.getCharges(ticket_bike) * 2, Receipt.getCharges(ticket_car));
    }
}
