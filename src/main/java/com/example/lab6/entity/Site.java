package com.example.lab6.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "site")
@Getter
@Setter
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SiteID")
    private int id;

    @MapsId("locationid")
    @ManyToOne
    @JoinColumn(name="LocationID")
    private Site locationid;

}
