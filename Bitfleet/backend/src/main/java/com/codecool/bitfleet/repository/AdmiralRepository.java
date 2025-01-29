package com.codecool.bitfleet.repository;

import com.codecool.bitfleet.repository.model.Admiral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmiralRepository extends JpaRepository<Admiral, Long> {
    Admiral findByUsername(String userName);
}
