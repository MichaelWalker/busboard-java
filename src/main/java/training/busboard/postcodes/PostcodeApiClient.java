package training.busboard.postcodes;

import training.busboard.postcodes.models.PostcodeData;
import training.busboard.postcodes.models.PostcodeResult;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class PostcodeApiClient {
    private final Client client;

    public PostcodeApiClient() {
        client = ClientBuilder.newClient();
    }

    public PostcodeData getPostcodeDate(String postcode) {
        PostcodeResult result = client
                .target("http://api.postcodes.io/")
                .path("postcodes/" + postcode)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(PostcodeResult.class);

        if (result.getStatus() == 200) {
            return result.getResult();
        }

        throw new RuntimeException(result.getError());
    }
}
