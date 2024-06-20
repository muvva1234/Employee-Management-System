package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// EmployeeRepository interface extends JpaRepository for CRUD operations
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Method to sort the list according to the last name in ascending order
    public List<Employee> findAllByOrderByLastNameAsc();
}