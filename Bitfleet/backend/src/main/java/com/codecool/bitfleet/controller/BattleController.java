package com.codecool.bitfleet.controller;


import com.codecool.bitfleet.dto.battle.BattleDTO;
import com.codecool.bitfleet.dto.battle.BattleRequestDTO;
import com.codecool.bitfleet.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/battle")
public class BattleController {

    private final BattleService battleService;

    @Autowired
    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @PostMapping("/start")
    public ResponseEntity<BattleDTO> startBattle(@RequestBody BattleRequestDTO request) {
        BattleDTO battle = battleService.startBattle(request.fleetId());
        return ResponseEntity.ok(battle);
    }
}
