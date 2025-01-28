package com.codecool.bitfleet.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ship")
public class Ship {

    @Id
    @GeneratedValue
    @Getter
    private long id;
    @Getter
    @Setter
    @Column(nullable = false)
    private String name;
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ShipType type;
    @Getter
    @Setter
    @Column(nullable = false)
    private int hp;
    @Getter
    @Setter
    @Column(nullable = false)
    private int la;
    @Getter
    @Setter
    @Column(nullable = false)
    private int ha;
    @Getter
    @Setter
    @Column(nullable = false)
    private int ta;
    @Getter
    @Setter
    @Column(nullable = false)
    private int org;
    @Getter
    @Setter
    @Column(nullable = false)
    private double vet;
    @Getter
    @Setter
    @Column(nullable = false)
    private boolean isRepairing;
    @Getter
    @Setter
    @Column(nullable = false)
    private boolean isSunken;
    @Getter
    @Setter
    @Column(nullable = false)
    private int value;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "admiral_id", nullable = false)
    private Admiral admiral;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "fleet_id", nullable = true)
    private Fleet fleet;

    public Ship() {}

    public Ship(String name, ShipType type, int hp, int la, int ha, int ta, int org,
                double vet, boolean isRepairing, boolean isSunken) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.la = la;
        this.ha = ha;
        this.ta = ta;
        this.org = org;
        this.vet = vet;
        this.isRepairing = isRepairing;
        this.isSunken = isSunken;
    }


}
