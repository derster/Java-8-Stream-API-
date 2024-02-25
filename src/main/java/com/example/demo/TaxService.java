package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.demo.EmployeeDAO.getEmplyees;
@Service
public class TaxService {
    public List<Employee> evaluateTaxUsers(){
        return getEmplyees().stream().filter(employee -> employee.getSalary() > 12000).toList();
    }

    public  Map<Long, List<Employee>> goupyBy(){
        Map<Long, List<Employee>> collect = getEmplyees().stream().filter(employee -> employee.getSalary() > 10000).collect(Collectors.groupingBy(Employee::getSalary));
        return collect;
    }

    public List<Employee> sortEmployees(){
        List<Employee> employees = getEmplyees();
        Collections.sort(employees, Comparator.comparing(Employee::getSalary).reversed());
        return employees;
    }

    public void sortForeach(){
        List<Employee> employees = getEmplyees();
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(employee -> System.out.println(employee.getSalary()));
    }

    public void sortCompare(){
        List<Employee> employees = getEmplyees();
        Collections.sort(employees, (emp1, emp2) -> (int) (emp2.getSalary()-emp1.getSalary()));
    }

    public void sortCompare2(){
        List<Employee> employees = getEmplyees();
        Collections.sort(employees, Comparator.comparing(Employee::getSalary));
    }
    public List<String> sortedStr(){
        return Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

    }
}
