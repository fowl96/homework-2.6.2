package com.example.homework2_6_2.controller;


import com.example.homework2_6_2.model.Employee;
import com.example.homework2_6_2.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public Employee getMin (@RequestParam("departmentId") int department) {
        return departmentService.getEmployWithMinSalary(department);
    }

    @GetMapping
    public Employee getMax (@RequestParam("departmentId") int department) {
        return departmentService.getEmployWithMaxSalary(department);
    }

    @GetMapping(value = "/all", params = "departmentId")
    private List<Employee> getAll(@RequestParam("departmentId") int department) {
        return departmentService.getEmployeeByDepartment(department);
    }

    @GetMapping(value = "/all")
    private Map<Integer, List<Employee>> getAll() {
        return departmentService.getEmployeeGrouped();
    }

}
