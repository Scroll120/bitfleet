package com.codecool.bitfleet.service;

import com.codecool.bitfleet.dto.Fleet.FleetDTO;
import com.codecool.bitfleet.exceptions.FleetNotFoundException;
import com.codecool.bitfleet.repository.FleetRepository;
import com.codecool.bitfleet.repository.model.Fleet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FleetService {

    private final FleetRepository fleetRepository;

    @Autowired
    public FleetService(FleetRepository fleetRepository) {
        this.fleetRepository = fleetRepository;
    }

    public List<FleetDTO> getAllUserFleets(long admiralId) {
        List<Fleet> fleets = fleetRepository.findAllByAdmiralId(admiralId);

        if (fleets.isEmpty()) {
            throw new FleetNotFoundException();
        }

        return fleets.stream().map(FleetDTO::fromFleet).collect(Collectors.toList());
    }

    public List<FleetDTO> getAllNoneUserFleets(long admiralId) {
        List<Fleet> fleets = fleetRepository.findAllNoneAdmiralFleets(admiralId);

        if (fleets.isEmpty()) {
            throw new FleetNotFoundException();
        }

        return fleets.stream().map(FleetDTO::fromFleet).collect(Collectors.toList());
    }

    public FleetDTO getFleetById(long fleetId) {
        Fleet fleet = fleetRepository.findById(fleetId).orElseThrow(FleetNotFoundException::new);
        return FleetDTO.fromFleet(fleet);
    }

}
