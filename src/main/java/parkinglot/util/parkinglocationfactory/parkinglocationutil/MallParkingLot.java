package parkinglot.util.parkinglocationfactory.parkinglocationutil;
/**
 * @author: Subodh
 * @version: 1.1
 *
 * @file: MallParkingLot
 * @Descritption: Get the parking price for Mall for different vehicle
 */
import parkinglot.parkingexception.ParkingExcption;
import parkinglot.parkingexception.VehicleException;
import parkinglot.util.priceconfigutil.PriceConfigReader;
import parkinglot.util.parkinglocationfactory.PriceHandlerInterface;

public class MallParkingLot implements PriceHandlerInterface {
    //Get the Parking fare for Mall parking
    public  int getPrice(String parkingLocation,String parkingVehicle,int duration){
        int price=0;
        try{
            price=PriceConfigReader.getPrice(parkingLocation,parkingVehicle,1);
            if(duration>0){
                price=duration*price;
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
