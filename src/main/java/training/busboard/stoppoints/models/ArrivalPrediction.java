package training.busboard.stoppoints.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArrivalPrediction {
    private Integer timeToStation;

    public Integer getTimeToStation() {
        return timeToStation;
    }
}
