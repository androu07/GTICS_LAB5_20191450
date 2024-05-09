package com.example.lab6.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class SiteID implements Serializable {
    @Column(name = "LocationID", nullable = false)
    private Integer locationid;
}
