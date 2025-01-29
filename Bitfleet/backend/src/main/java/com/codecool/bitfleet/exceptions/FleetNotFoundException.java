package com.codecool.bitfleet.exceptions;

public class FleetNotFoundException extends RuntimeException {
    public FleetNotFoundException() {
        super("Fleet not found");
    }
}
