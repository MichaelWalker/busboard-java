package training.busboard.stoppoints;

import training.busboard.stoppoints.models.ArrivalPrediction;
import training.busboard.stoppoints.models.NearbyStops;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StopPointApiClient {
    private static final String TARGET = "https://api.tfl.gov.uk/StopPoint";
    private final Client client;

    public StopPointApiClient() {
        client = ClientBuilder.newClient();
    }

    public List<ArrivalPrediction> getNextBusesForStop(String stopId) {
        try {
            ArrivalPrediction[] arrivalPredictions = client
                    .target(TARGET)
                    .path(String.format("%s/Arrivals", stopId))
                    .request(MediaType.APPLICATION_JSON)
                    .get(ArrivalPrediction[].class);
            return Arrays.asList(arrivalPredictions);
        } catch (Exception e) {
            System.out.println("\033[33mFailed to fetch arrival predictions\033[0m");
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public NearbyStops getNearestStops(Double latitude, Double longitude) {
        try {
            return client
                    .target(TARGET)
                    .queryParam("stopTypes", "NaptanPublicBusCoachTram")
                    .queryParam("lat", latitude)
                    .queryParam("lon", longitude)
                    .queryParam("radius", 1000)
                    .request(MediaType.APPLICATION_JSON)
                    .get(NearbyStops.class);
        } catch (Exception e) {
            System.out.println("\033[33mFailed to fetch nearby bus stops\033[0m");
            throw e;
        }
    }
}
