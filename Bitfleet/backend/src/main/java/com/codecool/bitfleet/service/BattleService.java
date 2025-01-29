package com.codecool.bitfleet.service;

import com.codecool.bitfleet.dto.Fleet.FleetDetailedDTO;
import com.codecool.bitfleet.dto.Ship.ShipBattleDTO;
import com.codecool.bitfleet.dto.battle.BattleDTO;
import com.codecool.bitfleet.exceptions.FleetNotFoundException;
import com.codecool.bitfleet.repository.FleetRepository;
import com.codecool.bitfleet.repository.ShipRepository;
import com.codecool.bitfleet.repository.model.Fleet;
import com.codecool.bitfleet.repository.model.Ship;
import com.codecool.bitfleet.repository.model.ShipType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BattleService {
    private final FleetRepository fleetRepository;
    private final ShipRepository shipRepository;

    @Autowired
    public BattleService(FleetRepository fleetRepository, ShipRepository shipRepository) {
        this.fleetRepository = fleetRepository;
        this.shipRepository = shipRepository;
    }

    public BattleDTO startBattle (long fleetId) {
        Fleet playerFleet = fleetRepository.findById(fleetId).
                orElseThrow(FleetNotFoundException::new);

        List<Fleet> enemyFleets = fleetRepository.findAllNoneAdmiralFleets(playerFleet.getAdmiral().getId());

        if (enemyFleets.isEmpty()) throw new FleetNotFoundException();

        String baseReport = "No engagement yet.";
        String test = "Ships are approaching another.";

        Fleet enemyFleet = enemyFleets.get(new Random().nextInt(enemyFleets.size()));
        return new BattleDTO(
                FleetDetailedDTO.fromFleet(playerFleet),
                FleetDetailedDTO.fromFleet(enemyFleet),
                List.of(baseReport, test));
    }

    private BattleDTO processTurn (BattleDTO currentBattle) {
        List<String> updatedReports = new ArrayList<>(currentBattle.battleReports());

        boolean playerStarts = new Random().nextBoolean();

        if (playerStarts) {
            performAttacks(currentBattle.playerFleet(), currentBattle.enemyFleet(), updatedReports);
        } else performAttacks(currentBattle.playerFleet(), currentBattle.enemyFleet(), updatedReports);

        return new BattleDTO(
                currentBattle.playerFleet(),
                currentBattle.enemyFleet(),
                updatedReports
        );
    }

    private void performAttacks(FleetDetailedDTO attackers, FleetDetailedDTO defender, List<String> battleReports) {
        Random random = new Random();

        double screeningEfficiency = defender.screening();

        List<ShipBattleDTO> screenShips = defender.ships().stream()
                .filter(ship -> ship.shipType() == ShipType.SCREEN)
                .collect(Collectors.toList());
        List<ShipBattleDTO> capitalShips = defender.ships().stream()
                .filter(ship -> ship.shipType() == ShipType.CAPITAL)
                .collect(Collectors.toList());


        for (ShipBattleDTO attacker : attackers.ships()) {
            if (attacker.isSunken()) continue;

            if (attacker.la() > 0) {
                List<ShipBattleDTO> validTargets = !screenShips.isEmpty() ? screenShips : capitalShips;
                if (!validTargets.isEmpty()) {
                    ShipBattleDTO target = validTargets.get(random.nextInt(validTargets.size()));
                    processHit();
                }
            }

            if (attacker.ha() > 0) {
                List<ShipBattleDTO> validTargets = !capitalShips.isEmpty() ? capitalShips : screenShips;
                if (!validTargets.isEmpty()) {
                    ShipBattleDTO target = validTargets.get(random.nextInt(validTargets.size()));
                    processHit();
                }
            }

            if (attacker.ta() > 0 && screeningEfficiency < 0.6) {
                if (!capitalShips.isEmpty()) {
                    ShipBattleDTO target = capitalShips.get(random.nextInt(capitalShips.size()));
                    processHit();
                }
            }
        }
    }

    public void processHit() {

    }

    private int calculateDamage(String attackType, ShipBattleDTO attacker) {
        return switch (attackType) {
            case "la" -> attacker.la();
            case "ha" -> attacker.ha();
            case "ta" -> attacker.ta();
            default -> 0;
        };
    }
}
