package com.database.SpringBootMongodbCRUD.service;

import com.database.SpringBootMongodbCRUD.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("service2")
public class EmployeeService1Impl implements EmployeeService{

    @Override
    public void createOneEmployee(Employee employee) {

    }

    @Override
    public void createManyEmployees(List<Employee> employees) {

    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return null;
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return null;
    }

    @Override
    public List<Employee> getEmployeeBySalary(Map<String ,Double> salary) {
        return null;
    }

    @Override
    public List<Employee> getEmployeeByJoinedDate(Map<String ,String> date) {
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployeeById(String id) {
    }
}
