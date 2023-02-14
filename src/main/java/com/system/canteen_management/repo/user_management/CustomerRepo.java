package com.system.canteen_management.repo.user_management;

import com.system.canteen_management.entity.user_management.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Optional<Customer> findCustomerByFullName(String fullName);
}
