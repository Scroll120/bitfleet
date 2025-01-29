package com.codecool.bitfleet.service;

import com.codecool.bitfleet.dto.Admiral.AdmiralDTO;
import com.codecool.bitfleet.dto.Admiral.AdmiralIdDTO;
import com.codecool.bitfleet.exceptions.UserFailedToAuthenticate;
import com.codecool.bitfleet.exceptions.UserNotFoundException;
import com.codecool.bitfleet.repository.AdmiralRepository;
import com.codecool.bitfleet.repository.model.Admiral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdmiralService {
    private final AdmiralRepository admiralRepository;

    @Autowired
    public AdmiralService(AdmiralRepository admiralRepository) {
        this.admiralRepository = admiralRepository;
    }

    public List<AdmiralDTO> getAllAdmirals() {
        List<Admiral> admirals = admiralRepository.findAll();

        if (admirals.isEmpty()) {
            throw new UserNotFoundException();
        }

        return admirals.stream().map(AdmiralDTO::fromAdmiral).collect(Collectors.toList());
    }

    public AdmiralDTO getAdmiralById(long admiralId) {
        Admiral admiral = admiralRepository.findById(admiralId).orElseThrow(UserNotFoundException::new);
        return AdmiralDTO.fromAdmiral(admiral);
    }

    public AdmiralIdDTO loginAdmiral(String username, String password) {
        Admiral admiral = admiralRepository.findByUsername(username);

        if (admiral == null) {
            throw new UserNotFoundException();
        }

        if (!admiral.getPassword().equals(password)) {
            throw new UserFailedToAuthenticate();
        }

        return AdmiralIdDTO.fromAdmiral(admiral);
    }

}
