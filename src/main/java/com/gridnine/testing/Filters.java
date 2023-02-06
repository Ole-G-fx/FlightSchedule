package com.gridnine.testing;

import java.util.List;

public interface Filters {

    List<Flight> apply(List<Flight> flights);
}
