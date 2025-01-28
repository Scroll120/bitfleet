package com.codecool.bitfleet.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fleet")
public class Fleet {

    @Id
    @GeneratedValue
    @Getter
    private long id;
    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    private String name;
    @Getter
    @Setter
    @OneToMany(mappedBy = "fleet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Ship> ships = new HashSet<>();
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "admiral_id", nullable = false)
    private Admiral admiral;
    @Getter
    @Setter
    @Column(nullable = false)
    private boolean isActive;
    @Getter
    @Setter
    @Column(nullable = false)
    private boolean isReserve;

    public Fleet(String name, Admiral admiral, boolean isActive, boolean isReserve) {
        this.name = name;
        this.admiral = admiral;
        this.isActive = isActive;
        this.isReserve = isReserve;
    }

    public Fleet() {}

    public void addShip(Ship ship) {
        ships.add(ship);
        ship.setFleet(this);
    }

    public void removeShip(Ship ship) {
        ships.remove(ship);
        ship.setFleet(null);
    }

    public double getScreening() {
        long capitalShips = ships.stream()
                .filter(ship -> ship.getType() == ShipType.CAPITAL)
                .count();
        long screeningShips = ships.stream()
                .filter(ship -> ship.getType() == ShipType.SCREEN)
                .count();

        if (screeningShips == 0) {
            return 0.0;
        }

        if (capitalShips == 0) {
            return 1.0;
        }

        double actualRatio = (double) screeningShips / (4 * screeningShips);
        return Math.min(actualRatio, 1.0);
    }

    public double getOrg() {
        int totalOrg = ships.stream().mapToInt(Ship::getOrg).sum();
        return !ships.isEmpty() ? (double) totalOrg / ships.size() : 0.0;
    }

    public int getValue () {
        return ships.stream().mapToInt(Ship::getValue).sum();
    }

}
