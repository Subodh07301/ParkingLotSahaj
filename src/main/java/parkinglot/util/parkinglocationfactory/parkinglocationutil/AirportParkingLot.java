package parkinglot.util.parkinglocationfactory.parkinglocationutil;

/**
 * @author: Subodh
 * @version: 1.1
 *
 * @file: AirportParkingLot
 * @Descritption: Get the parking price for Airport for different vehicle
 */

import parkinglot.parkingexception.ParkingExcption;
import parkinglot.parkingexception.VehicleException;
import parkinglot.util.priceconfigutil.PriceConfigReader;
import parkinglot.util.parkinglocationfactory.PriceHandlerInterface;

public class AirportParkingLot implements PriceHandlerInterface {
    //Get the parking fare
    public  int getPrice(String parkingLocation,String parkingVehicle,int duration){
        int price=0;
        try{
            price=PriceConfigReader.getPrice(parkingLocation,parkingVehicle,duration);
            if(duration>24){
                price=price*(duration/24);
            }
        }catch (ParkingExcption ex){
            ex.printStackTrace();
        }catch (VehicleException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return price;
    }
}
