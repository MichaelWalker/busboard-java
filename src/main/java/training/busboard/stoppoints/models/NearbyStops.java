package training.busboard.stoppoints.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NearbyStops {
    private List<StopPoint> stopPoints;

    public List<StopPoint> getStopPoints() {
        return stopPoints;
    }

    @JsonIgnore
    public List<StopPoint> getNearest(Integer limit) {
        return stopPoints.stream().limit(limit).collect(Collectors.toList());
    }
}
