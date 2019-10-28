package training.busboard.postcodes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostcodeResult {
    private Integer status;
    private PostcodeData result;

    public Integer getStatus() {
        return status;
    }

    public PostcodeData getResult() {
        return result;
    }
}
