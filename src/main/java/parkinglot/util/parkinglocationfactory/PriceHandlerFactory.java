package parkinglot.util.parkinglocationfactory;
/**
 * @author: Subodh
 * @version: 1.1
 *
 * @file: PriceHandlerFactory
 * @Descritption: This is a factory file which will provide instance
 * to handle parking for different location
 */


import parkinglot.parkingexception.ParkingExcption;
import parkinglot.util.parkinglocationfactory.parkinglocationutil.AirportParkingLot;
import parkinglot.util.parkinglocationfactory.parkinglocationutil.BasicParkingLot;
import parkinglot.util.parkinglocationfactory.parkinglocationutil.MallParkingLot;
import parkinglot.util.parkinglocationfactory.parkinglocationutil.StadiumParkingLot;

public class PriceHandlerFactory {
    //Declare ParkingLocation interface
    private static PriceHandlerInterface priceHandlerInterface=null;

    //Get an instance of the parking location price handler
    public  static PriceHandlerInterface getInstance(String parkingPlace) throws ParkingExcption {
        if(parkingPlace==null||parkingPlace.equals("")){
            throw new ParkingExcption("No such parking location exception");
        }
        switch (parkingPlace){
            case "Base":
                priceHandlerInterface=new BasicParkingLot();
                break;
            case "Airport":
                priceHandlerInterface=new AirportParkingLot();
                break;
            case "Stadium":
                priceHandlerInterface=new StadiumParkingLot();
                break;
            case "Mall":
                priceHandlerInterface=new MallParkingLot();
                break;
            default:
                throw new ParkingExcption("No supported parking location service");
        }

        return priceHandlerInterface;
    }

}
