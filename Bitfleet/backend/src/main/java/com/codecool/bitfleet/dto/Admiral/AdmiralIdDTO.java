package com.codecool.bitfleet.dto.Admiral;

import com.codecool.bitfleet.repository.model.Admiral;

public record AdmiralIdDTO(long id) {
    public static AdmiralIdDTO fromAdmiral(Admiral admiral) {
        return new AdmiralIdDTO(admiral.getId());
    }
}
