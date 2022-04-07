package org.github.zhengchalei.example.jpa;

import com.querydsl.collections.CollQueryFactory;
import ext.java.org.github.zhengchalei.example.jpa.QCustomer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class CustomerCollectionsTest {

    @Test
    public void test() {
        Set<Customer> customers = Stream.of("张媛", "刘春", "姜瓶", "史珊")
                .map(data -> Customer.builder().name(data).build())
                .collect(Collectors.toSet());
        QCustomer customer = QCustomer.customer;
        CollQueryFactory.from(customer, customers)
                .select(customer.name)
                .where(customer.name.eq("史珊"))
                .fetch()
                .forEach(data -> log.info("data: {}", data));
    }

}
