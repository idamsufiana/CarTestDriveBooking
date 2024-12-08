package com.hyundai.booking.CarTestdrive.repository;

import com.hyundai.booking.CarTestdrive.model.entity.BookingCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingCar, Long> {

    @Query("select d from BookingCar d where d.car.brand = ?1 and d.bookingDate = ?2 and d.timeSlot =?3")
    List<BookingCar> findAllBookingByCarDateTime(String carBrand, LocalDate Date, LocalTime Time);
}
