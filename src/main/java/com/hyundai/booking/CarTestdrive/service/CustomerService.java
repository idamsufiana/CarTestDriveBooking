package com.hyundai.booking.CarTestdrive.service;

import com.hyundai.booking.CarTestdrive.model.entity.CrudEntity;
import com.hyundai.booking.CarTestdrive.model.dto.CustomerDto;
import com.hyundai.booking.CarTestdrive.model.entity.Customer;
import com.hyundai.booking.CarTestdrive.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Optional<Customer> get(Long id){
        return customerRepository.findById(id);
    }

    public Customer createFromDto(CustomerDto dto){
        Customer customer = new Customer();
        BeanUtils.copyProperties(dto, customer);
        CrudEntity crudEntity = (CrudEntity)customer;
        crudEntity.setCreatedDate(new Date());
        customerRepository.save(customer);
        return customer;
    }

    public void delete(Customer id){
         this.customerRepository.delete(id);
    }

}
