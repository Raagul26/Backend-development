package com.database.SpringBootMongodbCRUD.service;

import com.database.SpringBootMongodbCRUD.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface EmployeeService {

    void createOneEmployee(Employee employee);

    void createManyEmployees(List<Employee> employees);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    List<Employee> getEmployeeByName(String name);

    List<Employee> getEmployeeBySalary(Map<String,Double> salary);

    List<Employee> getEmployeeByJoinedDate(Map<String ,String > date);

    void updateEmployee(Employee employee);

    void deleteEmployeeById(String id);

}
