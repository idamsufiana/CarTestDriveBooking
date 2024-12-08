package com.hyundai.booking.CarTestdrive.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name="customer")
@Entity
@Getter
@Setter
public class Customer extends CrudEntity {
    private String customerName;
    private String email;
    private String phone;
}
