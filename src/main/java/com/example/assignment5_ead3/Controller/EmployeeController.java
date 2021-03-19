package com.example.assignment5_ead3.Controller;

import com.example.assignment5_ead3.Entity.Employees;
import com.example.assignment5_ead3.Entity.EmployeesType;
import com.example.assignment5_ead3.Services.CalculatorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Controller
public class EmployeeController {
    Scanner s = new Scanner(System.in).useLocale(Locale.US);
    @Autowired
    CalculatorServiceInterface CalculatorServiceInterface;
    private static final DecimalFormat format = new DecimalFormat("#.##");
    @PostConstruct
    public void showMenu() {
        int c = 0;
        while (c != 6) {
            int i;
            System.out.println("""
                                        
                    \t\t\t\t<--Choose one operation-->
                    \t\t1. Change hour rate of employee
                    \t\t2. Change commission tate of employee
                    \t\t3. Change salary of employee
                    \t\t4. Calculate employees salaries
                    \t\t5. All employees information
                    \t\t6. Exit""");
            c = s.nextInt();
            switch (c) {
                case 1 -> {
                    System.out.println("\n\tEnter the employee id");
                    int id = s.nextInt();
                    System.out.println("\n\tEnter the new hour rate");
                    double rate = s.nextDouble();
                    CalculatorServiceInterface.changeHourRate(id, rate);
                }
                case 2 -> {
                    System.out.println("\n\tEnter the employee id");
                    int id = s.nextInt();
                    System.out.println("\n\tEnter the new commission rate");
                    float rate = s.nextFloat();
                    CalculatorServiceInterface.changeCommRate(id, rate);
                }
                case 3 -> {
                    System.out.println("\n\tEnter the employee id");
                    int id = s.nextInt();
                    System.out.println("\n\tEnter the new salary");
                    double salary = s.nextDouble();
                    CalculatorServiceInterface.changeSalary(id, salary);
                }
                case 4 -> {
                    System.out.println("\n\tSALARIED employees");
                    List<Employees> employee = CalculatorServiceInterface.getByType(EmployeesType.SALARIED);
                    System.out.println("\t\t" + employee.size() + " employees found.");
                    i = 1;
                    for (Employees employees : employee) {
                        System.out.println("\t\t" + i + ") " + employees.getName() + ": " + employees.getFixedsalary() + " tenges");
                        i++;
                    }
                    System.out.println("\n\tHOURLY employees");
                    employee = CalculatorServiceInterface.getByType(EmployeesType.HOURLY);
                    System.out.println("\t\t" + employee.size() + " employees found.");
                    i = 1;
                    for (Employees employees : employee) {
                        double salary = employees.getFixedsalary();
                        int hours = employees.getHoursworked();
                        if (hours > 40) {
                            System.out.println("\t\t" + i + ") " + employees.getName() + ": " +
                                    (salary * 40 + (hours - 40) * salary * employees.getHourrate()) + " (worked " + hours + " hours)");
                        } else {
                            System.out.println("\t\t" + i + ") " + employees.getName() + ": " + salary * hours);
                        }
                        i++;
                    }
                    System.out.println("\n\tCOMMISSION employees");
                    employee = CalculatorServiceInterface.getByType(EmployeesType.COMMISSION);
                    System.out.println("\t\t" + employee.size() + " employees found.");
                    i = 1;
                    for (Employees employees : employee) {
                        double salary = (employees.getFixedsalary() * employees.getCommrate());
                        System.out.println("\t\t" + i + ") " + employees.getName() + ": " + format.format(salary) + " tenges");
                        i++;
                    }
                    System.out.println("\n\tSALARIED COMMISSION employees");
                    employee = CalculatorServiceInterface.getByType(EmployeesType.SALARIED_COMMISSION);
                    System.out.println("\t\t" + employee.size() + " employees found.");
                    i = 1;
                    for (Employees employees : employee) {
                        double salary = ((employees.getFixedsalary() + employees.getCommrate() * employees.getFixedsalary()));
                        System.out.println("\t\t" + i + ") " + employees.getName() + ": " + format.format(salary) + " tenges");
                        i++;
                    }
                    System.out.println();
                }
                case 5 -> {
                    List<Employees> employee = CalculatorServiceInterface.findAll();
                    System.out.println("\tTotal number of employees: " + employee.size());
                    for (Employees employees : employee) {
                        String name = employees.getName();
                        long id = employees.getId();
                        double salary = employees.getFixedsalary();
                        double hourRate = employees.getHourrate();
                        float commRate = employees.getCommrate();
                        System.out.print(
                                "\n\tEmployee with ID: " + id +
                                        "\n\t\tName: " + name +
                                        "\n\t\tType: " + employees.getEmployeestype() +
                                        "\n\t\tSalary: " + format.format(salary) +
                                        "\n\t\tHour rate: " + format.format(hourRate) +
                                        "\n\t\tCommission rate: " + format.format(commRate));
                    }
                }
            }
        }
    }
}
