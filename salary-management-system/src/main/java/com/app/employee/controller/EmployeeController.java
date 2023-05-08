package com.app.employee.controller;

import com.app.employee.dto.EmployeeInfo;
import com.app.employee.messages.ResponseMessage;
import com.app.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/private/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ResponseMessage<?>> add(@Valid @RequestBody EmployeeInfo employeeInfo) {
        ResponseMessage responseMessage =  employeeService.add(employeeInfo);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.CREATED);
    }
}
