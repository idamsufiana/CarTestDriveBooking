package com.hyundai.booking.CarTestdrive.service;

import com.hyundai.booking.CarTestdrive.exception.HyundayException;
import com.hyundai.booking.CarTestdrive.model.entity.BookingCar;
import com.hyundai.booking.CarTestdrive.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public String Booking(String carName, LocalDate date, LocalTime time) throws HyundayException {
        List<BookingCar> data = bookingRepository.findAllBookingByCarDateTime(carName, date, time);
        if(!data.isEmpty()){
            throw new HyundayException("Data Already Exist");
        }else{
            BookingCar booking = new BookingCar();
            booking.setBookingDate(date);
            bookingRepository.save(booking);
            return "Success";
        }
    }

    public List<BookingCar> List(String carName, LocalDate date, LocalTime time) throws HyundayException {
        List<BookingCar> data = bookingRepository.findAllBookingByCarDateTime(carName, date, time);
        if(!data.isEmpty()){
            return data;
        }
        return new ArrayList<BookingCar>();
    }
}
