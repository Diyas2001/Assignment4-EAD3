package com.example.assignment5_ead3.Entity;
import javax.persistence.*;

@Entity
@Table(name = "employees")

public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double fixedsalary;
    private double hourrate;
    private int hoursworked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFixedsalary() {
        return fixedsalary;
    }

    public void setFixedsalary(double fixedsalary) {
        this.fixedsalary = fixedsalary;
    }

    public double getHourrate() {
        return hourrate;
    }

    public void setHourrate(double hourrate) {
        this.hourrate = hourrate;
    }

    public int getHoursworked() {
        return hoursworked;
    }

    public void setHoursworked(int hoursworked) {
        this.hoursworked = hoursworked;
    }

    public float getCommrate() {
        return commrate;
    }

    public void setCommrate(float commrate) {
        this.commrate = commrate;
    }

    public EmployeesType getEmployeestype() {
        return employeestype;
    }

    public void setEmployeestype(EmployeesType employeetype) {
        this.employeestype = employeestype;
    }

    private float commrate;
    @Enumerated(EnumType.STRING)
    private EmployeesType employeestype;
}
