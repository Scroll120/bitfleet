package com.codecool.bitfleet.dto.Fleet;

import com.codecool.bitfleet.repository.model.Fleet;

public record SimpleFleetDTO(long id, String name) {
    public static SimpleFleetDTO fromFleet(Fleet fleet) {
        return new SimpleFleetDTO(
                fleet.getId(),
                fleet.getName()
        );
    }
}
