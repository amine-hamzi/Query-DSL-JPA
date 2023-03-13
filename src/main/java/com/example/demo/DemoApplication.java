package com.example.demo;

import com.example.demo.entities.Customer;
import com.example.demo.entities.QCustomer;
import com.example.demo.repositories.CustomerRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 6; i++) {
            Customer customer = new Customer();
            customer.setFirstName("amine"+i);
            customer.setLastName("hamzi"+i);
            customerRepository.save(customer);
        }
        QCustomer customer = QCustomer.customer;
        BooleanExpression customerWithAm = customer.firstName.contains("1");
        List<Customer> customerList = (List<Customer>) customerRepository.findAll(customerWithAm);
        customerList.forEach(customer1 -> System.out.println(customer1));
    }
}
