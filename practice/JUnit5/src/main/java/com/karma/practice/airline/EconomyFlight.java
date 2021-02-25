package com.karma.practice.airline;

public class EconomyFlight extends Flight {

    public EconomyFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        return passengerList.add(passenger);
    }



    @Override
    public boolean removePassenger(Passenger passenger) {
        if (!passenger.isVip()) {
             return passengerList.remove(passenger);
        }
        return false;
    }
}
