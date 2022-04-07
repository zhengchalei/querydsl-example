package org.github.zhengchalei.example.jpa;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Slf4j
@SpringBootTest
public class CustomerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void test() {
        Set<Customer> customers = Stream.of("张媛", "刘春", "姜瓶", "史珊")
                .map(data -> Customer.builder().name(data).build())
                .collect(Collectors.toSet());

        List<Customer> activeCustomerList = this.customerRepository.saveAllAndFlush(customers);

        QCustomer customer = QCustomer.customer;

        this.customerRepository
                .findAll(customer.name.eq("张媛").or(customer.name.eq("刘春")))
                .forEach(data -> log.info(data.toString()));
    }

}
