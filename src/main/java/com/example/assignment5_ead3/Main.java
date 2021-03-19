package com.example.assignment5_ead3;
import com.example.assignment5_ead3.Config.Config;
import com.example.assignment5_ead3.Controller.EmployeeController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        EmployeeController employeeController = context.getBean("employeeController", EmployeeController.class);
    }
}
