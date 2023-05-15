/**
 * @Author: Subodh Kumar
 * @Version: 1.1
 *
 * @Description: This contains the logic for json parsing and getting
 * the price value for Vehicle Parking
 */
package parkinglot.util.priceconfigutil;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import parkinglot.constant.Constant;
import parkinglot.parkingexception.ParkingExcption;
import parkinglot.parkingexception.VehicleException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


public class PriceConfigReader {
    //Fetch the parking price for vehicle for parking location
    public static int getPrice(final String parkingLocation,final String vehicle_type,int duration)
            throws ParkingExcption, VehicleException {
        //Check the validation of parking location and
        // vehicle and throw exception if it is not valid
        if(parkingLocation==null||parkingLocation.equals("")){
            throw new ParkingExcption("Parking location exception");
        }
        if(vehicle_type==null||vehicle_type.equals("")){
            throw new VehicleException("No such vehicle exception");
        }

        //Get price for given parking location and vehicle type
        int vehicle_park_price=0;
        try {
            //Json parser to parse the PriceConfig file
            JSONParser parser = new JSONParser();

            JSONObject data = (JSONObject) parser.parse(
                    new FileReader(Constant.CONFIG_FILE_PATH));

            //Get the map from vehicle type for key=Duration value=charges
            Map price = (Map)((JSONObject)data.get(parkingLocation)).get(vehicle_type);

            //Iterate over duration to identify the charges
            Iterator<Map.Entry> itr1 = price.entrySet().iterator();
            while (itr1!=null && itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                String durations[]=((String)pair.getValue()).split(" ");
                vehicle_park_price=Integer.valueOf(pair.getValue().toString());
                if(durations.length==2){
                    if(duration>=Integer.valueOf(durations[0])&&
                            duration<Integer.valueOf(durations[1])){
                        break;
                    }
                }else if(Integer.valueOf(durations[0])<=duration){
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return vehicle_park_price;
    }

}
