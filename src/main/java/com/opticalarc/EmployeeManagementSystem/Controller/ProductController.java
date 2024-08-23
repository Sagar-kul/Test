////package com.opticalarc.EmployeeManagementSystem.Controller;
////
////import java.util.List;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.data.domain.Page;
////import org.springframework.data.domain.PageRequest;
////import org.springframework.data.domain.Pageable;
////import org.springframework.data.domain.Sort;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.PathVariable;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestBody;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RequestParam;
////import org.springframework.web.bind.annotation.RestController;
////
////import com.opticalarc.EmployeeManagementSystem.Entity.Product;
////import com.opticalarc.EmployeeManagementSystem.Entity.User;
////import com.opticalarc.EmployeeManagementSystem.services.ProductServices;
////
//////ProductController.java
////@RestController
////@RequestMapping("/products")
////public class ProductController {
////
//// @Autowired
//// private ProductServices productService;
////
//// @GetMapping("/{id}")
//// public Product getProductById(@PathVariable Integer id) {
////     return productService.getProductById(id);
//// }
////
//// @PostMapping
//// public Product saveProduct(@RequestBody Product product) {
////     return productService.saveProduct(product);
//// }
////
//// @GetMapping
//// public List<Product> getAllProducts() {
////     return productService.getAllProducts();
//// }
//// 
//// 
//// 
////}
////
//
//
//
//
//package com.opticalarc.EmployeeManagementSystem.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.opticalarc.EmployeeManagementSystem.Entity.Product;
//import com.opticalarc.EmployeeManagementSystem.services.ProductServices;
//
//@RestController
//@RequestMapping("/products")
//public class ProductController {
//
//    @Autowired
//    private ProductServices productService;
//
//    @GetMapping("/{id}")
//    public Product getProductById(@PathVariable Integer id) {
//        return productService.getProductById(id);
//    }
//
//    @PostMapping
//    public Product saveProduct(@RequestBody Product product) {
//        return productService.saveProduct(product);
//    }
//
//    @GetMapping
//    public List<Product> getAllProducts() {
//        return productService.getAllProducts();
//    }
//
//    @GetMapping("/pagination")
//    public ResponseEntity<List<Product>> getProductPagination(
//            @RequestParam int page,
//            @RequestParam int size,
//            @RequestParam(required = false) String sortBy,
//            @RequestParam(required = false) String sortDir) {
//        
//        if (sortBy == null || sortBy.isEmpty()) {
//            sortBy = "id";
//        }
//
//        if (sortDir == null || sortDir.isEmpty()) {
//            sortDir = "desc";
//        }
//
//        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
//        Pageable pageable = PageRequest.of(page, size, sort);
//        Page<Product> productPage = productService.findAll(pageable);
//        List<Product> productList = productPage.getContent();
//
//        return ResponseEntity.ok(productList);
//    }
//}










//package com.opticalarc.EmployeeManagementSystem.Controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//
//import com.opticalarc.EmployeeManagementSystem.Entity.Product;
//import com.opticalarc.EmployeeManagementSystem.exception.ProductNotFoundException;
//import com.opticalarc.EmployeeManagementSystem.services.ProductServices;
//
//@RestController
//@RequestMapping("/products")
//public class ProductController {
//
//    @Autowired
//    private ProductServices productService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
//        Optional<Product> product = productService.getProductById(id);
//        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
//        Product savedProduct = productService.saveProduct(product);
//        return ResponseEntity.ok(savedProduct);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Product>> getAllProducts() {
//        List<Product> products = productService.getAllProducts();
//        return ResponseEntity.ok(products);
//    }
//
//    @GetMapping("/pagination")
//    public ResponseEntity<List<Product>> getProductPagination(
//            @RequestParam int page,
//            @RequestParam int size,
//            @RequestParam(required = false) String sortBy,
//            @RequestParam(required = false) String sortDir) {
//        
//        if (sortBy == null || sortBy.isEmpty()) {
//            sortBy = "id";
//        }
//
//        if (sortDir == null || sortDir.isEmpty()) {
//            sortDir = "desc";
//        }
//
//        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
//        Pageable pageable = PageRequest.of(page, size, sort);
//        Page<Product> productPage = productService.findAll(pageable);
//        List<Product> productList = productPage.getContent();
//
//        return ResponseEntity.ok(productList);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product productDetails) {
//        Optional<Product> existingProductOptional = productService.getProductById(id);
//
//        if (existingProductOptional.isPresent()) {
//            Product existingProduct = existingProductOptional.get();
//            existingProduct.setProductName(productDetails.getProductName());
//            existingProduct.setPrice(productDetails.getPrice());
//            existingProduct.setQuantity(productDetails.getQuantity());
//            existingProduct.setUser(productDetails.getUser());
//            existingProduct.setTags(productDetails.getTags());
//
//            Product updatedProduct = productService.saveProduct(existingProduct);
//            return ResponseEntity.ok(updatedProduct);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
//        Optional<Product> existingProductOptional = productService.getProductById(id);
//
//        if (existingProductOptional.isPresent()) {
//            productService.deleteProduct(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    
//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex) {
//        return ResponseEntity.ok("Product Not found");
//    }
//    
//    
//}
//




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

import com.opticalarc.EmployeeManagementSystem.Entity.Product;
import com.opticalarc.EmployeeManagementSystem.exception.ProductNotFoundException;
import com.opticalarc.EmployeeManagementSystem.services.ProductServices;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServices productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                      .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    @PostMapping("")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/pagination")
    public ResponseEntity<List<Product>> getProductPagination(
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
        Page<Product> productPage = productService.findAll(pageable);
        List<Product> productList = productPage.getContent();

        return ResponseEntity.ok(productList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product productDetails) {
        Optional<Product> existingProductOptional = productService.getProductById(id);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            existingProduct.setProductName(productDetails.getProductName());
            existingProduct.setPrice(productDetails.getPrice());
            existingProduct.setQuantity(productDetails.getQuantity());
            existingProduct.setUser(productDetails.getUser());
            existingProduct.setTags(productDetails.getTags());

            Product updatedProduct = productService.saveProduct(existingProduct);
            return ResponseEntity.ok(updatedProduct);
        } else {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        Optional<Product> existingProductOptional = productService.getProductById(id);

        if (existingProductOptional.isPresent()) {
            productService.deleteProduct(id);
            return ResponseEntity.ok("Product has been deleted");
        } else {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
    }

    // Exception handling for ProductNotFoundException
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

