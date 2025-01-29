package com.codecool.bitfleet.service;

import com.codecool.bitfleet.dto.Fleet.FleetDTO;
import com.codecool.bitfleet.dto.battle.BattleDTO;
import com.codecool.bitfleet.exceptions.FleetNotFoundException;
import com.codecool.bitfleet.repository.FleetRepository;
import com.codecool.bitfleet.repository.model.Fleet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BattleService {
    private final FleetRepository fleetRepository;

    @Autowired
    public BattleService(FleetRepository fleetRepository) {
        this.fleetRepository = fleetRepository;
    }

    public BattleDTO startBattle (long fleetId) {
        Fleet playerFleet = fleetRepository.findById(fleetId).
                orElseThrow(FleetNotFoundException::new);

        List<Fleet> enemyFleets = fleetRepository.findAllNoneAdmiralFleets(playerFleet.getAdmiral().getId());

        if (enemyFleets.isEmpty()) throw new FleetNotFoundException();

        Fleet enemyFleet = enemyFleets.get(new Random().nextInt(enemyFleets.size()));
        return new BattleDTO(FleetDTO.fromFleet(playerFleet), FleetDTO.fromFleet(enemyFleet));
    }
}
