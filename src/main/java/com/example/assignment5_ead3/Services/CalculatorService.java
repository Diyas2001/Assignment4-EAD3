package com.example.assignment5_ead3.Services;

import com.example.assignment5_ead3.Entity.Employees;
import com.example.assignment5_ead3.Entity.EmployeesType;
import com.example.assignment5_ead3.Event.SalaryChangeEvent;
import com.example.assignment5_ead3.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CalculatorService implements CalculatorServiceInterface, ApplicationEventPublisherAware{
    @Autowired
    private EmployeeRepository employeeRepository;
    private ApplicationEventPublisher eventPublisher;

    @Override
    public List<Employees> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employees> getByType(EmployeesType employeesType) {
        return employeeRepository.findEmployeesByEmployeestype(employeesType);
    }

    @Override
    public Employees findById(long id) {
        return employeeRepository.findEmployeesById(id);
    }

    @Override
    public void changeSalary(long id, double salary) {
        Employees employees = findById(id);
        employees.setFixedsalary(salary);
        employeeRepository.save(employees);
        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, employees));
    }
    @Override
    public void changeHourRate(long id, double rate) {
        Employees employees = findById(id);
        employees.setHourrate(rate);
        employeeRepository.save(employees);
        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, employees));
    }
    @Override
    public void changeCommRate(long id, float rate) {
        Employees employees = findById(id);
        employees.setCommrate(rate);
        employeeRepository.save(employees);
        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, employees));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
