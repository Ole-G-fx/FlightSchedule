package com.gridnine.testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
public class FilterUnit {
    private List<Flight> flights;
    public FilterUnit(List<Flight> flights) {
        this.flights = flights;
    }
    public void Filter() {

        List<Filters> filtersList = FiltersBuilder
                .buildStart()
                .addFilterDepartureBeforeNow()
                .addFilterArrivalBeforeDeparture()
                .addFilterTimeBetweenSegments()
                .buildEnd();

        filtersList.forEach(filter -> {
            flights = filter.apply(flights);
            flights.forEach(System.out::println);
            System.out.println("<--------------------------------->");
        });
    }
}
