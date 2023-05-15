package parkinglot.parkingexception;

/**
 * @author: Subodh
 * @version: 1.1
 *
 * @file: VehicleException
 * @Descritption: This is specified if Vehicle is not
 * valid and so this exception will be thrown
 */

public class VehicleException extends Exception{
    VehicleException(){
        super();
    }
    public VehicleException(String msg){
        super(msg);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
