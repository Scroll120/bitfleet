package com.codecool.bitfleet.controller;

import com.codecool.bitfleet.dto.Fleet.FleetDTO;
import com.codecool.bitfleet.service.FleetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fleets")
public class FleetController {

    private final FleetService fleetService;

    @Autowired
    public FleetController(FleetService fleetService) {
        this.fleetService = fleetService;
    }

    @GetMapping("/all/{admiralId}")
    public List<FleetDTO> getAllUserFleets(@PathVariable long admiralId) { return fleetService.getAllUserFleets(admiralId); }

    @GetMapping("/all/not/{admiralId}")
    public List<FleetDTO> getAllNonUserFleets(@PathVariable long admiralId) { return fleetService.getAllNoneUserFleets(admiralId); }

    @GetMapping("/{fleetId}")
    public FleetDTO getFleetById(@PathVariable long fleetId) { return fleetService.getFleetById(fleetId); }
}
