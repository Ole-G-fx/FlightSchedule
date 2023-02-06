package com.gridnine.testing;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class FilterTimeBetweenSegments implements Filters {

    FilterTimeBetweenSegments(){};

    @Override
    public List<Flight> apply(List<Flight> flights) {
    AtomicReference<Long> accumulator = new AtomicReference<>(0L);
    return flights
        .stream()
        .filter(flight -> {
            flight.getSegments()
                    .stream()
                    .reduce(null,
                            (s1, s2) -> {
                                if (Objects.nonNull(s1)) {
                                    Duration duration = Duration
                                            .between(s1.getArrivalDate()
                                                    ,s2.getDepartureDate());
                                    accumulator.updateAndGet(v -> v + duration.toMillis());
                                }
                                return s2;
                            });
            if (accumulator.get() < 7200000L) {
                accumulator.set(0L);
                return true;
            } else {
                accumulator.set(0L);
                return false;
            }
        }).collect(Collectors.toList());
    }
}
