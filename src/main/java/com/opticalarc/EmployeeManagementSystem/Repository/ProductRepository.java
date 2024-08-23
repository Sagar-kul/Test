package com.opticalarc.EmployeeManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opticalarc.EmployeeManagementSystem.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
