package com.karma.practice.airline;

import java.util.*;

public abstract class Flight {

    private String id;
    Set<Passenger> passengerList = new HashSet<>();
    private int distance;



    public Flight(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public Set<Passenger> getPassengerList() {
        return Collections.unmodifiableSet(passengerList);
    }

    public abstract boolean addPassenger(Passenger passenger) ;

    public abstract boolean removePassenger(Passenger passenger) ;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
