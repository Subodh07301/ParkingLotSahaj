package parkinglot.driver;

/**
 * @author: Subodh
 * @version: 1.1
 *
 * @file: ParkingLotDriverMain
 * @Descritption: This is drier program to test the functionality for parking
 * and unparking of vehicle to parking location and verify the ticket and
 * receipt generation
 */

import parkinglot.parkingmanager.ParkingLotHandler;
import parkinglot.parkingmanager.Vehicle;
import parkinglot.tickethandler.Ticket;

public class ParkingLotDriverMain {
    public static void main(String args[]){
        ParkingLotHandler parkingLotHandler=new ParkingLotHandler.Builder().build();
        Ticket ticket1=parkingLotHandler.park(Vehicle.valueOf("CAR"),"Airport");
        Ticket ticket2=parkingLotHandler.park(Vehicle.valueOf("SUV"),"Airport");
        System.out.print(ticket1.toString());
        System.out.print(ticket2.toString());
        System.out.print(parkingLotHandler.unPark(ticket1));
        System.out.print(parkingLotHandler.unPark(ticket2));
    }
}
