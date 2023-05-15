package parkinglot.parkingexception;
/**
 * @author: Subodh
 * @version: 1.1
 *
 * @file: ParkingExcption
 * @Descritption: This is specified if parking location is not
 * valid and so this exception will be thrown
 */
public class ParkingExcption extends Exception{
    ParkingExcption(){
        super();
    }
    public ParkingExcption(String msg){
        super(msg);
    }

    @Override
    public void printStackTrace(){
        super.printStackTrace();
    }

    @Override
    public String getMessage(){
        return super.getMessage();
    }
}
