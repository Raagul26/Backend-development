package com.database.SpringBootMongodbCRUD.service;

import com.database.SpringBootMongodbCRUD.model.Employee;
import com.database.SpringBootMongodbCRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("service1")
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    public EmployeeRepository employeeRepository;

    // create
    @Override
    public void createOneEmployee(Employee employee) {
        employeeRepository.insert(employee);
    }

    @Override
    public void createManyEmployees(List<Employee> employees) {
        employeeRepository.insert(employees);
    }

    // read
    @Override
    public Employee getEmployeeById(String id)
    {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find employee by id %s",id)));
    }

    @Override
    public List<Employee> getEmployeeByName(String name)
    {
        if(employeeRepository.findByName(name).isEmpty())
        {
            throw new RuntimeException(String.format("Cannot find employee by name %s",name));
        }
        else
        {
            return employeeRepository.findByName(name);
        }
    }

    @Override
    public List<Employee> getEmployeeBySalary(Map<String,Double> salary)
    {
        if(employeeRepository.findBySalary(salary.get("min_salary"),salary.get("max_salary")).isEmpty())
        {
            throw new RuntimeException("No employees in the give range of salary");
        }
        else
        {
            return employeeRepository.findBySalary(salary.get("min_salary"),salary.get("max_salary"));
        }
    }

    @Override
    public List<Employee> getEmployeeByJoinedDate(Map<String,String> date)
    {
        return employeeRepository.findByJoinedDate(date.get("from"), date.get("to"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        if(employeeRepository.findAll().isEmpty())
        {
            throw new RuntimeException("No records found");
        }
        else
        {
            return employeeRepository.findAll();
        }
    }

    // update
    @Override
    public void updateEmployee(Employee employee) {
        Employee tempEmployee=employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find employee by id %s",employee.getId())));

        tempEmployee.setName(employee.getName());
        tempEmployee.setAge(employee.getAge());
        tempEmployee.setSalary(employee.getSalary());
        tempEmployee.setDesignation(employee.getDesignation());
        tempEmployee.setExperience(employee.getExperience());
        tempEmployee.setSkills(employee.getSkills());
        tempEmployee.setLastModified(java.time.LocalDate.now().toString());
        employeeRepository.save(tempEmployee);
    }

    // delete
    @Override
    public void deleteEmployeeById(String id) {
        if(employeeRepository.findById(id).isPresent())
        {
            employeeRepository.deleteById(id);
        }
        else
        {
            throw new RuntimeException(String.format("Cannot find employee by id %s",id));
        }
    }
}
