package com.prabha.itechapp;

import com.prabha.itechapp.model.Employee;
import com.prabha.itechapp.model.Role;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class EmployeeController {
    @RequestMapping(value = "/employee/all")
    List<Employee> getEmployees() {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Priya");
        Role role = new Role();
        role.setDesignation("Chief Engineer");
        role.setDept("IT Dept");
        e1.setRole(role);

        Employee e2 = new Employee();
        e2.setId(2);
        e2.setName("Rekha");
        Role role2 = new Role();
        role.setDesignation("The CEO");
        role.setDept("Management");
        e2.setRole(role2);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        return employeeList;
    }
}
