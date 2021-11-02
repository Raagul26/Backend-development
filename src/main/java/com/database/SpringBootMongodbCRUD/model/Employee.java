package com.database.SpringBootMongodbCRUD.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document("employee")
public class Employee {

    @Id
    @NonNull
    private String id;
    @NonNull
    private String name;
    @NonNull
    private int age;
    @NonNull
    private double salary;
    @NonNull
    private String designation;
    @NonNull
    private double experience;
    @NonNull
    private List<String> skills;
    @Field("joined_date")
    @NonNull
    private String joinedDate;
    @Field("last_modified")
    private String lastModified;
}
