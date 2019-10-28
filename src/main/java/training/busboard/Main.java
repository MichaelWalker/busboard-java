package training.busboard;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class Main {
    public static void main(String args[]) {
        Client client = ClientBuilder.newClient();
        ArrivalPrediction[] arrivalPredictions = client
                .target("https://api.tfl.gov.uk/StopPoint/490008660N/Arrivals")
                .request(MediaType.APPLICATION_JSON)
                .get(ArrivalPrediction[].class);

        System.out.println(arrivalPredictions);
    }
}	
