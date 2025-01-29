package com.codecool.bitfleet.controller;

import com.codecool.bitfleet.dto.Admiral.AdmiralDTO;
import com.codecool.bitfleet.service.AdmiralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
