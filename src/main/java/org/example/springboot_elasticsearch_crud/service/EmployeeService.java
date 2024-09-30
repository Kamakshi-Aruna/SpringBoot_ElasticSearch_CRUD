package org.example.springboot_elasticsearch_crud.service;

import org.example.springboot_elasticsearch_crud.model.Employee;
import org.example.springboot_elasticsearch_crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    //   Adding the Employee Details
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    //   Get the Employee Details using id
    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    //   Get All the Employee Details
    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    //   Delete the Employee Details using id
    public void deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
    }

    //   DeleteAll the Employee Details
    public void deleteAllEmployees() {
        Iterable<Employee> iterable = employeeRepository.findAll();
        for (Employee employee : iterable) {
            employeeRepository.deleteAll();
        }
    }

    //   Update the Employee Details
    public String updateEmployee(Employee employee) {
        Optional<Employee> op = employeeRepository.findById(employee.getId());
        if (op.isPresent()) {
            employee.setId(op.get().getId());
            employeeRepository.save(employee);
            return "Data updated Successfully!!";
        } else {
            return "No Data found";
        }
    }

    //  Search the Employee using name
    public List<Employee> findEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

//  Search the Employee Details using range
    public List<Employee> findBySalaryRange(double min, double max) {
        return employeeRepository.findBySalaryBetween(min, max);
    }

}

