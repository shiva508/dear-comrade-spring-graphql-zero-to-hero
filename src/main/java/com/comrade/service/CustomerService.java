package com.comrade.service;

import com.comrade.model.Customer;
import com.comrade.model.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerService {
    public List<Customer> customersList(){
        return List.of(new Customer(408,"Shiva"),new Customer(508,"Dasari"));
    }

    public Customer findByCustomerId(Integer id){
        return customersList().stream().filter(customer -> customer.id().equals(id)).findFirst()
                .orElseThrow(()->new RuntimeException("Data Not"));
    }

    public Profile getProfileById(Customer customer){
        return new Profile(customer.id(), customer.id());
    }
}
