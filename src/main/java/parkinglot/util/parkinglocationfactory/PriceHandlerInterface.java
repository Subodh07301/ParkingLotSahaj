package parkinglot.util.parkinglocationfactory;

/**
 * @author: Subodh
 * @version: 1.1
 *
 * @file: PriceHandlerInterface
 * @Descritption: This interface will having the prototype for
 * parking getting the price
 */

public interface PriceHandlerInterface {
    public int getPrice(String parkingPlace,String vehicleType,int duration);
}
