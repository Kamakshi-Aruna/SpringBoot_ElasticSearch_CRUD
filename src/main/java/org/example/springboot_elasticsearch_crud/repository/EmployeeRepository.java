package org.example.springboot_elasticsearch_crud.repository;

import org.example.springboot_elasticsearch_crud.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    List<Employee> findByName(String name);
    List<Employee> findBySalaryBetween(double min, double max);
}
