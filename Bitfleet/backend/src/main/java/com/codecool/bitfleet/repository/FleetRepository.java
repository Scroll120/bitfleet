package com.codecool.bitfleet.repository;

import com.codecool.bitfleet.repository.model.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FleetRepository extends JpaRepository<Fleet, Long> {
}
