package training.busboard;

import training.busboard.postcodes.PostcodeApiClient;
import training.busboard.postcodes.models.PostcodeData;

import java.util.Scanner;

public class UserInput {
    private Scanner scanner;
    private PostcodeApiClient postcodeApiClient;

    public UserInput() {
        scanner = new Scanner(System.in);
        postcodeApiClient = new PostcodeApiClient();
    }

    public PostcodeData getPostcode() {
        PostcodeData postcodeData = null;

        while (postcodeData == null) {
            System.out.println("Please enter postcode");
            String postcode = scanner.nextLine();
            postcodeData = postcodeApiClient.getPostcodeDate(postcode);
        }

        return postcodeData;
    }
}
