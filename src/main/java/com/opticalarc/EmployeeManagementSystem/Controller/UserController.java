package com.opticalarc.EmployeeManagementSystem.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.opticalarc.EmployeeManagementSystem.Entity.User;
import com.opticalarc.EmployeeManagementSystem.Repository.UserRepository;
import com.opticalarc.EmployeeManagementSystem.dao.UpdateUserDao;
import com.opticalarc.EmployeeManagementSystem.dao.UserDao;
import com.opticalarc.EmployeeManagementSystem.exception.UserNotFoundException;
import com.opticalarc.EmployeeManagementSystem.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServices userServices;

    @PostMapping("")
    public ResponseEntity<User> create(@RequestBody UserDao userDao) {
        return ResponseEntity.ok(this.userServices.createUser(userDao));
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userServices.getAllUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userServices.getUserById(id));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundExceptionEntity() {
        return ResponseEntity.ok("User Not Found");
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody UpdateUserDao updateUserDao) {
        return ResponseEntity.ok(this.userServices.updateUser(id, updateUserDao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        this.userServices.deleteUser(id);
        return ResponseEntity.ok("User has been Deleted");
    }

    @GetMapping("/pagination")
    public ResponseEntity<List<User>> getUserPagination(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<User> userPage = userRepository.findAll(pageable);
        List<User> userList = userPage.getContent();
        return ResponseEntity.ok(userList);
    }
}

