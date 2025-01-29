package com.codecool.bitfleet.dto.battle;

import com.codecool.bitfleet.dto.Fleet.FleetDTO;

public record BattleDTO(FleetDTO playerFleet, FleetDTO enemyFleet) {
}
