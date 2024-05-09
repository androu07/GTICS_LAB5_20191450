package com.example.lab6.entity;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "technician")
@Getter
@Setter
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianID")
    private int id;
    @Column(nullable = false)
    private String FirstName;
    private String LastName;
    private String Dni;
    private String Phone;
    private int Age;

}
