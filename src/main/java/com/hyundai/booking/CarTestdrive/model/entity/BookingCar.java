package com.hyundai.booking.CarTestdrive.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@Table(name = "booking_car")
@Entity
public class BookingCar extends CrudEntity {
    private LocalDate bookingDate;
    private LocalTime timeSlot;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }


}
