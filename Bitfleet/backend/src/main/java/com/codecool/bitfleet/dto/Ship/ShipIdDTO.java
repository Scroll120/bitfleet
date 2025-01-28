package com.codecool.bitfleet.dto.Ship;

import com.codecool.bitfleet.repository.model.Ship;

public record ShipIdDTO(long id) {
    public static ShipIdDTO fromShip(Ship ship) {
        return new ShipIdDTO(ship.getId());
    }
}
