package com.example.lab6.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class EquiposID implements Serializable{
    @Column(name = "SiteID", nullable = false)
    private Integer siteid;
}
