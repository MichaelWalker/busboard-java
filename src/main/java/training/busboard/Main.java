package training.busboard;

import training.busboard.postcodes.PostcodeApiClient;
import training.busboard.postcodes.models.PostcodeData;
import training.busboard.stoppoints.models.ArrivalPrediction;
import training.busboard.stoppoints.models.NearbyStops;
import training.busboard.stoppoints.models.StopPoint;
import training.busboard.stoppoints.StopPointApiClient;

import java.util.List;


public class Main {
    public static void main(String args[]) {
        UserInput userInput = new UserInput();
        StopPointApiClient stopPointApiClient = new StopPointApiClient();

        System.out.println("Welcome to BusBoard!\n");

        PostcodeData postcode = userInput.getPostcode();
        NearbyStops nearestStops = stopPointApiClient.getNearestStops(
                postcode.getLatitude(),
                postcode.getLongitude()
        );

        for (StopPoint stopPoint : nearestStops.getNearest(2)) {
            List<ArrivalPrediction> nextBuses = stopPointApiClient.getNextBusesForStop(stopPoint.getStopId());
            System.out.println(nextBuses);
        }
    }
}	
