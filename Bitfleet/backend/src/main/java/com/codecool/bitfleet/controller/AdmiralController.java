package com.codecool.bitfleet.controller;

import com.codecool.bitfleet.dto.Admiral.AdmiralDTO;
import com.codecool.bitfleet.dto.Admiral.AdmiralIdDTO;
import com.codecool.bitfleet.dto.Admiral.LoginRequest;
import com.codecool.bitfleet.service.AdmiralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/admirals")
public class AdmiralController {
    private final AdmiralService admiralService;

    @Autowired
    public AdmiralController(AdmiralService admiralService) {
        this.admiralService = admiralService;
    }

    @GetMapping("/all")
    public List<AdmiralDTO> getAll() { return admiralService.getAllAdmirals(); }

    @GetMapping("/{admiralId}")
    public AdmiralDTO getAdmiralById(@PathVariable long admiralId) { return admiralService.getAdmiralById(admiralId); }

    @PostMapping("/login")
    public AdmiralIdDTO loginAdmiral(@RequestBody LoginRequest loginRequest) {
        return admiralService.loginAdmiral(loginRequest.username(), loginRequest.password());
    }

}
