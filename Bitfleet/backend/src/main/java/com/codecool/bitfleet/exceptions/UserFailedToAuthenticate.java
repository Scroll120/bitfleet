package com.codecool.bitfleet.exceptions;

public class UserFailedToAuthenticate extends RuntimeException {
    public UserFailedToAuthenticate() {
        super("Failed to authenticate");
    }
}
