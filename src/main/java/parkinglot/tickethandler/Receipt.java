package parkinglot.tickethandler;
/**
 * @author: Subodh
 * @version: 1.1
 *
 * @file: Receipt
 * @Descritption: This will generate the Receipt with different important field with
 * proper charge
 */

import parkinglot.parkingexception.ParkingExcption;
import parkinglot.parkingmanager.Vehicle;
import parkinglot.util.parkinglocationfactory.PriceHandlerFactory;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Receipt {

    public String generateReceipt(Ticket ticket){
        try {
            int charges= Receipt.getCharges(ticket);
            return "\n\n-:Charge Receipt For Ticket ID:-"+ticket.getId()+
                    "\n===================================="+
                    "\nParking Location: "+ticket.getParkingLocation()+
                    "\nVehicle: "+ticket.getVehicle()+
                    "\nTotal Charges: "+charges+
                    "\nCharged For Duration: "+ ticket.getDuration()+ " Hours"+
                    "\nUn park time: "+ LocalDate.now();

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return "Receipt will not be generated please check";
    }

    public static String forVehicle(@NotNull Ticket ticket){
        return ticket.getVehicle();
    }

    public static int getCharges(@NotNull Ticket ticket) throws ParkingExcption {
        return PriceHandlerFactory.getInstance(ticket.getParkingLocation()).
                getPrice(ticket.getParkingLocation(),ticket.getVehicle(),ticket.getDuration());
    }
}
