//package com.opticalarc.EmployeeManagementSystem.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.opticalarc.EmployeeManagementSystem.Entity.Product;
//import com.opticalarc.EmployeeManagementSystem.Repository.ProductRepository;
//
////ProductService.java
//@Service
//public class ProductServices {
//
// @Autowired
// private ProductRepository productRepository;
//
// public Product getProductById(Integer id) {
//     return productRepository.findById(id).orElse(null);
// }
//
// public Product saveProduct(Product product) {
//     return productRepository.save(product);
// }
//
// public List<Product> getAllProducts() {
//     return productRepository.findAll();
// }
//}
//





//package com.opticalarc.EmployeeManagementSystem.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import com.opticalarc.EmployeeManagementSystem.Entity.Product;
//import com.opticalarc.EmployeeManagementSystem.Repository.ProductRepository;
//
//@Service
//public class ProductServices {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    public Product getProductById(Integer id) {
//        return productRepository.findById(id).orElse(null);
//    }
//
//    public Product saveProduct(Product product) {
//        return productRepository.save(product);
//    }
//
//    public List<Product> getAllProducts() {
//        return productRepository.findAll();
//    }
//
//    public Page<Product> findAll(Pageable pageable) {
//        return productRepository.findAll(pageable);
//    }
//}





package com.opticalarc.EmployeeManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.opticalarc.EmployeeManagementSystem.Entity.Product;
import com.opticalarc.EmployeeManagementSystem.Repository.ProductRepository;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    // Get a product by its ID
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    // Save or update a product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get paginated products
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    // Delete a product by its ID
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}


