package org.sidorov.springboot.controller;

import org.sidorov.springboot.entity.Employee;
import org.sidorov.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployee();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }

    @PostMapping(path ="/employees/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployee(@RequestBody Employee employee){
        System.out.println(employee.toString());
        employeeService.saveEmployee(employee);
        return employee;
    }
}
