package com.codecool.bitfleet.repository.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "admiral")
public class Admiral {

    @Id
    @Getter
    private long id;
    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    private String username;
    @Getter
    @Setter
    @Column(nullable = false)
    private String password;
    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    private String email;
    @Getter
    @Setter
    @OneToMany(mappedBy = "admiral", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Fleet> fleets;
    @Getter
    @Setter
    @OneToMany(mappedBy = "admiral", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Ship> ships;
    @Getter
    @Setter
    private int funds;

    public Admiral(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fleets = new HashSet<>();
        this.ships = new HashSet<>();
        this.funds = 0;
    }

    public Admiral() {}

    public void addFleet(Fleet fleet) {
        fleets.add(fleet);
        fleet.setAdmiral(this);
    }

    public void addShip(Ship ship) {
        ships.add(ship);
        ship.setAdmiral(this);
    }

    public void removeFleet(Fleet fleet) {
        fleets.remove(fleet);
        fleet.setAdmiral(null);
    }

    public void removeShip(Ship ship) {
        ships.remove(ship);
        ship.setAdmiral(null);
    }

}
