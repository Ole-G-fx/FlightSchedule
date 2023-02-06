package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class FiltersBuilder{

    public static Builder buildStart(){

        return new Builder();
    };
    public static class Builder {

        static List<Filters> list = new ArrayList<>();

        public Builder addFilterDepartureBeforeNow() {

            list.add(new FilterDepartureBeforeNow());
            return this;
        }

        public Builder addFilterArrivalBeforeDeparture() {

            list.add(new FilterArrivalBeforeDeparture());
            return this;
        }

        public Builder addFilterTimeBetweenSegments() {

            list.add(new FilterTimeBetweenSegments());
            return this;
        }

        public List<Filters> buildEnd(){
            return list;
        }
    };
}
