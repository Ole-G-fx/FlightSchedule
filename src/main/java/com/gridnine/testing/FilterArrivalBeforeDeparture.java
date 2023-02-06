package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FilterArrivalBeforeDeparture implements Filters {

    FilterArrivalBeforeDeparture(){};

    @Override
    public List<Flight> apply(List<Flight> flights) {
        return flights
                .stream()
                .filter(flight ->
                        flight.getSegments()
                                .stream()
                                .noneMatch(segment -> segment
                                        .getArrivalDate()
                                        .isBefore(segment
                                                .getDepartureDate())))
                .collect(Collectors.toList());
    }
}
