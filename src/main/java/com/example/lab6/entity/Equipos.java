package com.example.lab6.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "device")
@Getter
@Setter
public class Equipos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DeviceID")
    private int id;

    @MapsId("siteid")
    @ManyToOne
    @JoinColumn(name="SiteID")
    private Site siteid;
}
