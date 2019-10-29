package training.busboard.stoppoints.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StopPoint {
    private String stopId;
    private String name;

    @JsonProperty("naptanId")
    public String getStopId() {
        return stopId;
    }

    @JsonProperty("commonName")
    public String getName() {
        return name;
    }
}
