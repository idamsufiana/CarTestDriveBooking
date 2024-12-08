package com.hyundai.booking.CarTestdrive.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name="car")
@Entity
@Getter
@Setter
public class Car extends CrudEntity {
    private String brand;
    private String model;
    private int year;
    private String imageUrl;
}
