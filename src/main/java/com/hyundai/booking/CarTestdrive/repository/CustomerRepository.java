package com.hyundai.booking.CarTestdrive.repository;

import com.hyundai.booking.CarTestdrive.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
