package training.busboard.stoppoints;

import training.busboard.stoppoints.models.ArrivalPrediction;
import training.busboard.stoppoints.models.NearbyStops;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

public class StopPointApiClient {
    private static final String TARGET = "https://api.tfl.gov.uk/StopPoint";
    private final Client client;

    public StopPointApiClient() {
        client = ClientBuilder.newClient();
    }

    public List<ArrivalPrediction> getNextBusesForStop(String stopId) {
        ArrivalPrediction[] arrivalPredictions = client
                .target(TARGET)
                .path(String.format("%s/Arrivals", stopId))
                .request(MediaType.APPLICATION_JSON)
                .get(ArrivalPrediction[].class);
        return Arrays.asList(arrivalPredictions);
    }

    public NearbyStops getNearestStops(Double latitude, Double longitude) {
        return client
                .target(TARGET)
                .queryParam("stopTypes", "NaptanPublicBusCoachTram")
                .queryParam("lat", latitude)
                .queryParam("lon", longitude)
                .queryParam("radius", 1000)
                .request(MediaType.APPLICATION_JSON)
                .get(NearbyStops.class);
    }
}
