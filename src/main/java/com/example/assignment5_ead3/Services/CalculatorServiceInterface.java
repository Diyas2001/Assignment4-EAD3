package com.example.assignment5_ead3.Services;

import com.example.assignment5_ead3.Entity.Employees;
import com.example.assignment5_ead3.Entity.EmployeesType;

import java.util.List;

public interface CalculatorServiceInterface {
    List<Employees> findAll();
    List<Employees> getByType(EmployeesType employeesType);
    Employees findById(long id);
    void changeSalary(long id, double salary);
    void changeHourRate(long id, double rate);
    void changeCommRate(long id, float rate);
}
