package com.opticalarc.EmployeeManagementSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.opticalarc.EmployeeManagementSystem.Entity.User;
import com.opticalarc.EmployeeManagementSystem.Repository.UserRepository;
import com.opticalarc.EmployeeManagementSystem.dao.UpdateUserDao;
import com.opticalarc.EmployeeManagementSystem.dao.UserDao;
import com.opticalarc.EmployeeManagementSystem.exception.UserNotFoundException;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;
	
public User createUser(UserDao userDao) {
		
		User user = new User();
		
		user.setFirstname(userDao.getFirstname());
		user.setLastname(userDao.getLastname());
		user.setEmail(userDao.getEmail());
		user.setPassword(userDao.getPassword());
		user.setMobile(userDao.getMobile());
		
		this.userRepository.save(user);
		
		return user;
	}

	public List<User> getAllUser(){
		return this.userRepository.findAll();
}
	
	public User getUserById(Integer id) {
		User user = this.userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User Not Found"));
		
		if(user == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user Does not Exist");
		}
		
		
		return user;
		
	}
	
	public void deleteUser(Integer id) {
		User user = this.getUserById(id);
		
		if(user == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user Does not Exist");
		}
		
		this.userRepository.delete(user);
		
	}
	
	public List<User> getAllUsers() {
        return userRepository.findAll();
    }
	
	
	
	public User updateUser(Integer id, UpdateUserDao updateUserDao) {
		User user = this.getUserById(id);
		
		if(updateUserDao.getFirstname() != null) {
			user.setFirstname(updateUserDao.getFirstname());
		}
		
		if(updateUserDao.getLastname() != null) {
			user.setLastname(updateUserDao.getLastname());
		}
		
		if(updateUserDao.getEmail() != null) {
			user.setEmail(updateUserDao.getLastname());
		}
		
		if(updateUserDao.getPassword() != null) {
			user.setPassword(updateUserDao.getPassword());
		}
		
		if(updateUserDao.getMobile() != null) {
			user.setMobile(updateUserDao.getMobile());
		}
		
		this.userRepository.save(user);
		
		
		return user;
	}	
	
}
