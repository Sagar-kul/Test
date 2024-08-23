package com.opticalarc.EmployeeManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.opticalarc.EmployeeManagementSystem.Entity.Brand;
import com.opticalarc.EmployeeManagementSystem.exception.BrandNotFoundException;
import com.opticalarc.EmployeeManagementSystem.services.BrandServices;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandServices brandServices;

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Integer id) {
        Optional<Brand> brand = brandServices.getBrandById(id);
        return brand.map(ResponseEntity::ok)
                    .orElseThrow(() -> new BrandNotFoundException("Brand not found with id: " + id));
    }

    @PostMapping("")
    public ResponseEntity<Brand> saveBrand(@RequestBody Brand brand) {
        Brand savedBrand = brandServices.saveBrand(brand);
        return ResponseEntity.ok(savedBrand);
    }

    @GetMapping("")
    public ResponseEntity<List<Brand>> getAllBrands() {
        List<Brand> brands = brandServices.getAllBrands();
        return ResponseEntity.ok(brands);
    }

    @GetMapping("/pagination")
    public ResponseEntity<List<Brand>> getBrandPagination(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String sortDir) {
        
        if (sortBy == null || sortBy.isEmpty()) {
            sortBy = "id";
        }

        if (sortDir == null || sortDir.isEmpty()) {
            sortDir = "desc";
        }

        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Brand> brandPage = brandServices.findAll(pageable);
        List<Brand> brandList = brandPage.getContent();

        return ResponseEntity.ok(brandList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Integer id, @RequestBody Brand brandDetails) {
        Optional<Brand> existingBrandOptional = brandServices.getBrandById(id);

        if (existingBrandOptional.isPresent()) {
            Brand existingBrand = existingBrandOptional.get();
            existingBrand.setName(brandDetails.getName());
            existingBrand.setProducts(brandDetails.getProducts());

            Brand updatedBrand = brandServices.saveBrand(existingBrand);
            return ResponseEntity.ok(updatedBrand);
        } else {
            throw new BrandNotFoundException("Brand not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable Integer id) {
        Optional<Brand> existingBrandOptional = brandServices.getBrandById(id);

        if (existingBrandOptional.isPresent()) {
            brandServices.deleteBrand(id);
            return ResponseEntity.ok("Brand has been deleted");
        } else {
            throw new BrandNotFoundException("Brand not found with id: " + id);
        }
    }

    // Exception handling for BrandNotFoundException
    @ExceptionHandler(BrandNotFoundException.class)
    public ResponseEntity<String> handleBrandNotFoundException(BrandNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
