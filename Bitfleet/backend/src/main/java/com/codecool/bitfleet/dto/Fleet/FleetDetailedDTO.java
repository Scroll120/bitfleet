package com.codecool.bitfleet.dto.Fleet;

import com.codecool.bitfleet.dto.Ship.ShipBattleDTO;
import com.codecool.bitfleet.dto.Ship.ShipIdDTO;
import com.codecool.bitfleet.repository.model.Fleet;

import java.util.Set;
import java.util.stream.Collectors;

public record FleetDetailedDTO(long id, String name, Set<ShipBattleDTO> ships, long admiralId, double screening,
                               double org, int value) {
    public static FleetDetailedDTO fromFleet(Fleet fleet) {
        return new FleetDetailedDTO(
                fleet.getId(),
                fleet.getName(),
                fleet.getShips().stream()
                        .map(ShipBattleDTO::fromShip).
                        collect(Collectors.toSet()),
                fleet.getAdmiral().getId(),
                fleet.getScreening(),
                fleet.getOrg(),
                fleet.getValue()
        );
    }
}
