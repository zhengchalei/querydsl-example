package org.github.zhengchalei.example.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CustomerRepository extends
        JpaRepository<Customer, Long>,
        JpaSpecificationExecutor<Customer>,
        QuerydslPredicateExecutor<Customer> {
}
