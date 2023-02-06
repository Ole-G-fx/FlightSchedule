package com.gridnine.testing;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        FilterUnit filterUnit = new FilterUnit(FlightBuilder.createFlights());
        filterUnit.Filter();
    }
}
