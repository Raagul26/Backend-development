package com.database.SpringBootMongodbCRUD.controller;

import com.database.SpringBootMongodbCRUD.controller.resp.APIResponse;
import com.database.SpringBootMongodbCRUD.model.Employee;
import com.database.SpringBootMongodbCRUD.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Qualifier("service1")
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<APIResponse> create(@RequestBody Employee employee)
    {
        APIResponse response = new APIResponse();
        try
        {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            response.setStatus("error");
            response.setErrorCode("400");
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/createMany", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<APIResponse> create(@RequestBody List<Employee> employees)
    {
        APIResponse response = new APIResponse();
        try
        {
            employeeService.createManyEmployees(employees);
            response.setStatus("success");
            response.setMessage("Records Created Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            response.setStatus("error");
            response.setMessage(e.getMessage());
            response.setErrorCode("400");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAll()
    {
        APIResponse response = new APIResponse();
        try
        {
            response.setStatus("success");
            response.setMessage("Fetched Successfully");
            response.setData(employeeService.getAllEmployees());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            response.setStatus("error");
            response.setErrorCode("404");
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> get(@PathVariable String id)
    {
        APIResponse response = new APIResponse();
        try
        {
            response.setStatus("success");
            response.setMessage("Fetched Successfully");
            response.setData(employeeService.getEmployeeById(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            response.setStatus("error");
            response.setErrorCode("404");
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getByName(@PathVariable String name)
    {
        APIResponse response = new APIResponse();
        try
        {
            response.setStatus("success");
            response.setMessage("Fetched Successfully");
            response.setData(employeeService.getEmployeeByName(name));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.setStatus("error");
            response.setErrorCode("404");
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/salary")
    public ResponseEntity<Object> getBySalary(@RequestBody Map<String ,Double> salary)
    {
        APIResponse response = new APIResponse();
        try
        {
            response.setStatus("success");
            response.setMessage("Fetched Successfully");
            response.setData(employeeService.getEmployeeBySalary(salary));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.setStatus("error");
            response.setErrorCode("404");
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/joined_date")
    public ResponseEntity<APIResponse> getByJoinedDate(@RequestBody Map<String,String> date)
    {
        APIResponse response = new APIResponse();
        try
        {
            response.setStatus("success");
            response.setMessage("Fetched Successfully");
            response.setData(employeeService.getEmployeeByJoinedDate(date));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            response.setStatus("error");
            response.setErrorCode("400");
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<APIResponse> update(@RequestBody Employee employee)
    {
        APIResponse response = new APIResponse();
        try
        {
            employeeService.updateEmployee(employee);
            response.setStatus("success");
            response.setMessage("Updated Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            response.setStatus("error");
            response.setErrorCode("404");
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> delete(@PathVariable String id)
    {
        APIResponse response = new APIResponse();
        try
        {
            employeeService.deleteEmployeeById(id);
            response.setStatus("success");
            response.setMessage("Deleted Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e)
        {
            response.setStatus("error");
            response.setErrorCode("404");
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }
}
