package com.karma.praticetest.milage;


import com.karma.practice.airline.Flight;
import com.karma.practice.airline.Passenger;
import com.karma.practice.milage.Milage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MilageTest {

    private Milage milage;

    @BeforeAll
    void beforeAll() {
        milage  = new Milage();
    }

    @ParameterizedTest
    @Disabled
    @ValueSource(strings = { "1; e; Mike; false; 349", "2; b; John; true; 278",  "3; e; Mike; false; 319", "4; p; John; true; 817", "5; e; Mike; false; 623", "6; e; John; true; 978"})
    void checkGivenPoints(@ConvertWith(FlightArgumentConverter.class) Flight flight) {
        for (Passenger passenger: flight.getPassengerList()) {
            milage.addMilage(passenger, flight.getDistance());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/flights_information.csv")
    void checkGivenPointsWithCsvInput(@ConvertWith(FlightArgumentConverter.class) Flight flight) {
        for (Passenger passenger: flight.getPassengerList()) {
            milage.addMilage(passenger, flight.getDistance());
        }
    }

    @AfterAll
    void afterAll() {
        milage.calculateGivenPoints();
        assertEquals(33, milage.getPassengersPointsMap().get(new Passenger("Mike", false)).intValue());
        assertEquals(109, milage.getPassengersPointsMap().get(new Passenger("John", true)).intValue());
        System.out.println(milage.getPassengersPointsMap());
    }
}
