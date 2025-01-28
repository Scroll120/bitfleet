package com.codecool.bitfleet.dto.Ship;

import com.codecool.bitfleet.repository.model.Admiral;
import com.codecool.bitfleet.repository.model.Fleet;
import com.codecool.bitfleet.repository.model.Ship;
import com.codecool.bitfleet.repository.model.ShipType;

public record ShipDTO (long id, String name, ShipType shipType, int hp, int la, int ha, int ta, int org,
                       double vet, boolean isRepairing, boolean isSunken, long admiral_id, long fleet_id) {
    public static ShipDTO fromShip (Ship ship) {
        return new ShipDTO(
                ship.getId(),
                ship.getName(),
                ship.getType(),
                ship.getHp(),
                ship.getLa(),
                ship.getHa(),
                ship.getTa(),
                ship.getOrg(),
                ship.getVet(),
                ship.isRepairing(),
                ship.isSunken(),
                ship.getAdmiral().getId(),
                ship.getFleet().getId()
        );
    }
}
