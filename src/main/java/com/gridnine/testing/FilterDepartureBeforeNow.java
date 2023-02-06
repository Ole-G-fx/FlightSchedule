package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDepartureBeforeNow implements Filters {

    FilterDepartureBeforeNow(){};

    @Override
    public List<Flight> apply(List<Flight> flights) {
        return flights
                .stream()
                .filter(flight ->
                        flight.getSegments()
                                .stream()
                                .anyMatch(segment -> segment
                                        .getDepartureDate()
                                        .isAfter(LocalDateTime.now()))
                )
                .collect(Collectors.toList());
    }
}
