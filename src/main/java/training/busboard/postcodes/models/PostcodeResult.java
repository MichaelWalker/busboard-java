package training.busboard.postcodes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostcodeResult {
    private Integer status;
    private PostcodeData result;
    private String error;

    public Integer getStatus() {
        return status;
    }

    public PostcodeData getResult() {
        return result;
    }

    public String getError() {
        return error;
    }
}
