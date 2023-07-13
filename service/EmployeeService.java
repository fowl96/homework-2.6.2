package com.example.homework2_6_2.service;

import com.example.homework2_6_2.exception.EmployeeAlreadyAddedException;
import com.example.homework2_6_2.exception.EmployeeNotFoundException;
import com.example.homework2_6_2.exception.EmployeeStorageIsFullException;
import com.example.homework2_6_2.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class EmployeeService {

    private static final int SIZE_LIMIT = 5;
    private final Collection<Employee> employees = new ArrayList<>(SIZE_LIMIT);


    public Collection<Employee> getAll(){
        return employees;
    }

    public Employee add(Employee employee) {
        if (employees.size()>=SIZE_LIMIT){
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    public Employee find(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }

        throw new EmployeeNotFoundException();
    }

    public Employee remove(String firstName, String lastName){
        Employee employee = find(firstName, lastName);
        employees.remove(employee);
        return employee;
    }

}
