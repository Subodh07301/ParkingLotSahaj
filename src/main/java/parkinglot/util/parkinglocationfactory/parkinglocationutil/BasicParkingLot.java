package parkinglot.util.parkinglocationfactory.parkinglocationutil;
/**
 * @author: Subodh
 * @version: 1.1
 *
 * @file: AirportParkingLot
 * @Descritption: Get the parking price for Base for different vehicle
 */
import parkinglot.parkingexception.ParkingExcption;
import parkinglot.parkingexception.VehicleException;
import parkinglot.util.priceconfigutil.PriceConfigReader;
import parkinglot.util.parkinglocationfactory.PriceHandlerInterface;

public class BasicParkingLot implements PriceHandlerInterface {
    //Get Parking fare for base location for different location
    public  int getPrice(String parkingLocation,String parkingVehicle,int duration){
        int price=0;
        try{
            price=PriceConfigReader.getPrice(parkingLocation,parkingVehicle,duration);
            if(duration>12){
                price=(duration-12)*price;
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
