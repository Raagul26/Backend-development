package com.database.SpringBootMongodbCRUD.repository;

import com.database.SpringBootMongodbCRUD.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {

    List<Employee> findByName(String name);

    @Query("{salary:{$gte:?0,$lte:?1}}")
    List<Employee> findBySalary(double minSalary, double maxSalary);

    @Query("{joined_date:{$gte:?0,$lte:?1}}")
    List<Employee> findByJoinedDate(String fromDate, String toDate);

}
