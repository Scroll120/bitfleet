package com.codecool.bitfleet.dto.Fleet;

import com.codecool.bitfleet.dto.Ship.ShipIdDTO;
import com.codecool.bitfleet.repository.model.Admiral;
import com.codecool.bitfleet.repository.model.Fleet;

import java.util.Set;
import java.util.stream.Collectors;

public record FleetDTO (long id, String name, Set<ShipIdDTO> ships, long admiralId, boolean isActive,
                        boolean isReserve) {
    public static FleetDTO fromFleet(Fleet fleet) {
        return new FleetDTO(
                fleet.getId(),
                fleet.getName(),
                fleet.getShips().stream()
                        .map(ShipIdDTO::fromShip).
                        collect(Collectors.toSet()),
                fleet.getAdmiral().getId(),
                fleet.isActive(),
                fleet.isReserve()
        );
    }
}
