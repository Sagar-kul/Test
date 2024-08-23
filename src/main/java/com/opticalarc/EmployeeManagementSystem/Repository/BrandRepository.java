package com.opticalarc.EmployeeManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opticalarc.EmployeeManagementSystem.Entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
