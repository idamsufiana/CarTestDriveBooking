package com.hyundai.booking.CarTestdrive.repository;

import com.hyundai.booking.CarTestdrive.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
