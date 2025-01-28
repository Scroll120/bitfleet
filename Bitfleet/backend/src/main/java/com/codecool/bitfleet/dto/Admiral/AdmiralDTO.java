package com.codecool.bitfleet.dto.Admiral;

import com.codecool.bitfleet.dto.Fleet.FleetIdDTO;
import com.codecool.bitfleet.dto.Ship.ShipIdDTO;
import com.codecool.bitfleet.repository.model.Admiral;
import com.codecool.bitfleet.repository.model.Fleet;

import java.util.Set;
import java.util.stream.Collectors;

public record AdmiralDTO (long id, String username, String email,
                          Set<FleetIdDTO> fleets, Set<ShipIdDTO> ships, int funds) {
    public static AdmiralDTO fromAdmiral(Admiral admiral) {
        return new AdmiralDTO(
                admiral.getId(),
                admiral.getUsername(),
                admiral.getEmail(),
                admiral.getFleets().stream().
                        map(FleetIdDTO::fromFleet).
                        collect(Collectors.toSet()),
                admiral.getShips().stream().
                        map(ShipIdDTO::fromShip).
                        collect(Collectors.toSet()),
                admiral.getFunds()
        );
    }
}
