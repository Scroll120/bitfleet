package com.codecool.bitfleet.dto.Ship;

import com.codecool.bitfleet.repository.model.Ship;
import com.codecool.bitfleet.repository.model.ShipType;

public record ShipBattleDTO(long id, String name, ShipType shipType, int hp, int la, int ha, int ta, int org,
                            double vet, boolean isSunken) {
    public static ShipBattleDTO fromShip(Ship ship) {
        return new ShipBattleDTO(
                ship.getId(),
                ship.getName(),
                ship.getType(),
                ship.getHp(),
                ship.getLa(),
                ship.getHa(),
                ship.getTa(),
                ship.getOrg(),
                ship.getVet(),
                ship.isSunken()
        );
    }
}
