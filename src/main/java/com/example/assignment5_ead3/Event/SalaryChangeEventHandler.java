package com.example.assignment5_ead3.Event;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component

public class SalaryChangeEventHandler implements ApplicationListener<SalaryChangeEvent> {
    @Override
    @EventListener
    public void onApplicationEvent(SalaryChangeEvent salaryChangeEvent) {
        System.out.println(salaryChangeEvent.employees.getName() + "'s salary was changed.");
    }
}
