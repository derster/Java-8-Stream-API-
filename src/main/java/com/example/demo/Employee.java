package com.example.demo;

public class Employee {
    private Long Id;
    private String name;
    private Long salary;
    private String domain;

    public Employee(Long id, String name, Long salary, String domain) {
        Id = id;
        this.name = name;
        this.salary = salary;
        this.domain = domain;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public Long getSalary() {
        return salary;
    }

    public String getDomain() {
        return domain;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", domain='" + domain + '\'' +
                '}';
    }
}
