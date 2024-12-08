package com.hyundai.booking.CarTestdrive.controller;

import com.hyundai.booking.CarTestdrive.exception.HyundayException;
import com.hyundai.booking.CarTestdrive.service.BookingService;
import com.sun.net.httpserver.Authenticator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping({"Hyundai/TestDrive"})
@Slf4j
public class BookingController extends BaseController{

    @Autowired
    private BookingService bookingService;

    @PostMapping("/BookCar")
    public ResponseEntity<?> Booking(@RequestParam String CarBrand,
                                     @RequestParam String BookingDate,
                                     @RequestParam String TimeSloth) throws HyundayException {
        LocalDate localDate = LocalDate.parse(BookingDate);
        LocalTime localTime = LocalTime.parse(TimeSloth);
        return this.success(bookingService.Booking(CarBrand, localDate, localTime));
    }

    @GetMapping("/list")
    public ResponseEntity<?> List(@RequestParam String CarBrand,
                                  @RequestParam String BookingDate,
                                  @RequestParam String TimeSloth) throws HyundayException {
        LocalDate localDate = LocalDate.parse(BookingDate);
        LocalTime localTime = LocalTime.parse(TimeSloth);
        return this.success(bookingService.List(CarBrand, localDate, localTime));
    }
}
