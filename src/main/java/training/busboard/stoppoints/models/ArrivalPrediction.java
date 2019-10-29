package training.busboard.stoppoints.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArrivalPrediction {
    private Integer timeToStation;
    private String lineName;

    public Integer getTimeToStation() {
        return timeToStation;
    }

    public String getLineName() {
        return lineName;
    }

    @Override
    public String toString() {
        return String.format("Line: %-8s Arrives In: %d", lineName, timeToStation);
    }
}
