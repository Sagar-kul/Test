package com.opticalarc.EmployeeManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.opticalarc.EmployeeManagementSystem.Entity.Brand;
import com.opticalarc.EmployeeManagementSystem.Repository.BrandRepository;

@Service
public class BrandServices {

    @Autowired
    private BrandRepository brandRepository;

    // Get a brand by its ID
    public Optional<Brand> getBrandById(Integer id) {
        return brandRepository.findById(id);
    }

    // Save or update a brand
    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    // Get all brands
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    // Get paginated brands
    public Page<Brand> findAll(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

    // Delete a brand by its ID
    public void deleteBrand(Integer id) {
        brandRepository.deleteById(id);
    }
}
