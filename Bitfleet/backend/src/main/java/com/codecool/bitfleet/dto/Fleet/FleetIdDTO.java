package com.codecool.bitfleet.dto.Fleet;

import com.codecool.bitfleet.repository.model.Fleet;

public record FleetIdDTO (long id) {
    public static FleetIdDTO fromFleet(Fleet fleet) {
        return new FleetIdDTO(fleet.getId());
    }
}
