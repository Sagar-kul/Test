package com.opticalarc.EmployeeManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.opticalarc.EmployeeManagementSystem.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
List<User> id(Integer id);
	
	
	
	@Query(value = "select * from user order by id", nativeQuery = true)
	List<User> sortByName();
}
