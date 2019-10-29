package training.busboard;

import training.busboard.postcodes.models.PostcodeData;
import training.busboard.stoppoints.StopPointApiClient;
import training.busboard.stoppoints.models.ArrivalPrediction;
import training.busboard.stoppoints.models.NearbyStops;
import training.busboard.stoppoints.models.StopPoint;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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
            System.out.println("\n" + stopPoint.getName());
            for (ArrivalPrediction prediction : getNextBuses(5, stopPoint.getStopId(), stopPointApiClient)) {
                System.out.println(prediction);
            }
        }
    }

    private static List<ArrivalPrediction> getNextBuses(Integer limit, String stopId, StopPointApiClient stopPointApiClient) {
        return stopPointApiClient.getNextBusesForStop(stopId)
                .stream()
                .sorted(Comparator.comparingInt(ArrivalPrediction::getTimeToStation))
                .limit(limit)
                .collect(Collectors.toList());
    }
}	
