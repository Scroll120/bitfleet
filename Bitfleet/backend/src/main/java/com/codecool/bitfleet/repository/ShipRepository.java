package com.codecool.bitfleet.repository;

import com.codecool.bitfleet.repository.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    List<Ship> findAllByFleetId(long fleetId);
}
