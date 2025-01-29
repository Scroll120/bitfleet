package com.codecool.bitfleet.dto.battle;

import com.codecool.bitfleet.dto.Fleet.FleetDetailedDTO;

import java.util.List;

public record BattleDTO(
        FleetDetailedDTO playerFleet,
        FleetDetailedDTO enemyFleet,
        List<String> battleReports) {
}
