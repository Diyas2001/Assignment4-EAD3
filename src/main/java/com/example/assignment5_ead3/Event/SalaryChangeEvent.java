package com.example.assignment5_ead3.Event;
import com.example.assignment5_ead3.Entity.Employees;
import org.springframework.context.ApplicationEvent;

public class SalaryChangeEvent extends ApplicationEvent {
    Employees employees;
    public SalaryChangeEvent(Object source, Employees employees) {
        super(source);
        this.employees = employees;
    }
}
