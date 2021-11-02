package com.database.SpringBootMongodbCRUD.controller.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse {

    private String status;

    private String errorCode;

    private String message;

    private Object data;
}
