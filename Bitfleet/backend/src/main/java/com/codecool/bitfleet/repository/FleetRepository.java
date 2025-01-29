package com.codecool.bitfleet.repository;

import com.codecool.bitfleet.repository.model.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FleetRepository extends JpaRepository<Fleet, Long> {
    List<Fleet> findAllByAdmiralId(
            long admiralId
    );

    @Query("SELECT f FROM Fleet f WHERE f.admiral.id <> :admiralId")
    List<Fleet> findAllNoneAdmiralFleets(@Param("admiralId") long admiralId);
}
