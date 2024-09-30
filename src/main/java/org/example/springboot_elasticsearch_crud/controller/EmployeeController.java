package org.example.springboot_elasticsearch_crud.controller;

import org.example.springboot_elasticsearch_crud.model.Employee;
import org.example.springboot_elasticsearch_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

//    Adding the Employee Details
    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
            employeeService.saveEmployee(employee);
            return "Data Inserted Successfully!!";
    }

//    Get all the Employee by using id
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable String id) {
       return employeeService.getEmployeeById(id);
    }

//    Getting all the Employee Details
    @GetMapping
    public Iterable<Employee> getAllEmployees() {
       return employeeService.getEmployees();
    }

//    Delete the Employee Details using id
    @DeleteMapping("/{id}")
    public String deleteEmployeeBYId(@PathVariable String id) {
        employeeService.deleteEmployeeById(id);
        return "Data Deleted Successfully!!";
    }

//    Delete All the Employee Details
    @DeleteMapping
    public String deleteEmployees(){
        employeeService.deleteAllEmployees();
       return "Data Deleted Successfully!!";
    }

//   Update the Employee Details
    @PutMapping
    public String updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

//   Search the employee Details using name
    @GetMapping("/search")
    public List<Employee> searchByName(@RequestParam String name) {
        return employeeService.findEmployeeByName(name);
    }

//    Search the Employee details using the range
    @GetMapping("/search/salary")
    public List<Employee> searchBySalaryRange(@RequestParam double min, @RequestParam double max) {
        return employeeService.findBySalaryRange(min, max);
    }
}
