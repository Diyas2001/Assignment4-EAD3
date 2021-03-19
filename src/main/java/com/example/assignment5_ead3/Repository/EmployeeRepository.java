package com.example.assignment5_ead3.Repository;

import com.example.assignment5_ead3.Entity.Employees;
import com.example.assignment5_ead3.Entity.EmployeesType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long> {
    List<Employees> findEmployeesByEmployeestype(EmployeesType employeesType);
    Employees findEmployeesById(long id);
    List<Employees> findAll();
}
