package com.codewade.department.controller;

import com.codewade.department.entity.Department;
import com.codewade.department.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/departments")
@Slf4j
@Api("API for CRUD operations on a user's department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    @ApiOperation(value = "Save one department to assign to one or many users",code = 201)
    public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department){
        log.info("Inside saveDepartment method of DepartmentController");
        Department saveDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find department user with an ID not null and exist",code = 200)
    public ResponseEntity<Department> findDepartmentById(@Valid @PathVariable("id")  Long departmentId){
        log.info("Inside findDepartmentById method of DepartmentController");
        Department findDepartment = departmentService.findDepartmentById(departmentId);
        return new ResponseEntity<>(findDepartment, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update department  with ID not null and exist",code = 200)
    public ResponseEntity<Department> UpdateDepartment(@Valid @PathVariable("id") Long departmentId, Department department){
        log.info("Inside UpdateDepartment method of DepartmentController");
        Department UpdateDepartment = departmentService.UpdateDepartment(departmentId,department);
        return new ResponseEntity<>(UpdateDepartment, HttpStatus.OK);
    }
}
