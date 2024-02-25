package com.example.demo;

import java.util.*;

public class EmployeeDAO {
    public static List<Employee> getEmplyees(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "Modeste", 30000L, "IT"));
        employees.add(new Employee(2L, "Pierre", 12000L, "CA"));
        employees.add(new Employee(3L, "Marc", 30000L, "CA"));
        employees.add(new Employee(3L, "Max", 13000L, "CORE"));
        employees.add(new Employee(3L, "Paule", 11000L, "JAVA"));
        return employees;
    }

    public static Map<Employee, Integer> getEmployeeMap(){
        Map<Employee, Integer> empMap = new TreeMap<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getSalary().compareTo(o1.getSalary());
            }
        });

        empMap.put(new Employee(1L, "Modeste", 30000L, "IT"), 30);
        empMap.put(new Employee(2L, "Pierre", 12000L, "CA"), 80);
        empMap.put(new Employee(3L, "Marc", 30000L, "CA"), 60);
        empMap.put(new Employee(3L, "Max", 13000L, "CORE"), 40);
        empMap.put(new Employee(3L, "Paule", 11000L, "JAVA"), 50);

        return empMap;
    }
}
