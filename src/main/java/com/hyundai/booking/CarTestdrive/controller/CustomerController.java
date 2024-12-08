package com.hyundai.booking.CarTestdrive.controller;

import com.hyundai.booking.CarTestdrive.model.dto.CustomerDto;
import com.hyundai.booking.CarTestdrive.model.entity.Customer;
import com.hyundai.booking.CarTestdrive.service.CustomerService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping({"Hyundai/Customer"})
@Slf4j
public class CustomerController extends BaseController{

    @Autowired
    CustomerService customerService;

    @GetMapping({"/{id}"})
    public ResponseEntity<Object> get(@PathVariable Long id) throws Throwable {
        Optional<Customer> optionalE = customerService.get(id);
        return optionalE.isPresent() ? this.success(optionalE.get()) : this.error(HttpStatus.NOT_FOUND, "Object not found");
    }

    @PostMapping({""})
    public ResponseEntity<Object> create(@RequestBody @Valid CustomerDto dto) throws Throwable {
        return this.success(customerService.createFromDto(dto));
    }

    @PostMapping({"/{id}"})
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody @Valid CustomerDto dto) throws Throwable {
        Optional<Customer> optionalE = customerService.get(id);
        if (optionalE.isPresent()) {
            Customer updatedEntity = customerService.createFromDto(dto);
            return this.success(updatedEntity);
        } else {
            return this.error(HttpStatus.NOT_FOUND, "Object not found");
        }
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Object> delete(@PathVariable Long id) throws Throwable {
        Optional<Customer> optionalE = customerService.get(id);
        if (optionalE.isPresent()) {
            customerService.delete(optionalE.get());
            return this.success("Object was deleted");
        } else {
            return this.error(HttpStatus.NOT_FOUND, "Object not found");
        }
    }


}
