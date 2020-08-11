package com.prabha.itechapp;

import com.prabha.itechapp.model.Employee;
import com.prabha.itechapp.model.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {
    List<Employee> employeeList = new ArrayList<>();

    @RequestMapping(value = "/employee/all")
    List<Employee> getEmployees(){
        List<Employee> employeeList = prepareData();
        return employeeList;
    }
    /*
    @RequestMapping(value = "/employee/{id}")
    public Employee getEmployeeById(@PathVariable Integer id)
    {
        List<Employee> employeeList = prepareData();
        for(Employee employee: employeeList)
            if (employee.getId() == id)
                return employee;
            return null;
    }*/

    @RequestMapping(value = "/employee/{id}")
    public ResponseEntity getEmployeeById(@PathVariable Integer id)
    {
        List<Employee> employeeList = prepareData();
        for(Employee employee: employeeList)
            if (employee.getId() == id)
            {
                ResponseEntity responseEntity = new ResponseEntity(employee, HttpStatus.OK);
                return responseEntity;
            }
        Map<String,String> map = new HashMap<>();
        map.put("message","Employee not found");
        ResponseEntity responseEntity = new ResponseEntity(map, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    // Create new Employee
    @RequestMapping(value = "/employee/create" , method = RequestMethod.POST)
    public ResponseEntity createEmployee(@RequestBody Employee employee)
    {
        addEmployee(employee);
        Map<String,String> map = new HashMap<>();
        map.put("message","Employee added Successfully");
        ResponseEntity responseEntity = new ResponseEntity(map,HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/employee/update",method = RequestMethod.PUT)
    public ResponseEntity updateEmployee(@RequestBody Employee employee)
    {
        boolean updated = updateMyEmployee(employee);
        Map<String,String> map = new HashMap<>();
        ResponseEntity responseEntity;

        if(updated){
            map.put("message","Employee updated successfully");
            responseEntity = new ResponseEntity(map,HttpStatus.OK);
        }
        else
        {
            map.put("message","Employee not found for update");
            responseEntity = new ResponseEntity(map,HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    private List<Employee> prepareData() {

        if(employeeList.isEmpty()) {
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
            role2.setDesignation("The CEO");
            role2.setDept("Management");
            e2.setRole(role2);

            employeeList.add(e1);
            employeeList.add(e2);
        }
        return employeeList;
    }
    private void addEmployee(Employee employee) {
        List<Employee> employeeList = prepareData();
         employeeList.add(employee);
    }

    private boolean updateMyEmployee(Employee tobeUpdatedEmployee) {
        List<Employee> employeeList = prepareData();

        Iterator<Employee> iterator = employeeList.iterator();
        boolean removed = false;

        while(iterator.hasNext()) {
            Employee employee = iterator.next();
            if(employee.getId() == tobeUpdatedEmployee.getId()) {
                iterator.remove();
                removed = true;
                break;
            }
        }
        if(removed) {
            employeeList.add(tobeUpdatedEmployee);
        }
        return removed;
    }

}
