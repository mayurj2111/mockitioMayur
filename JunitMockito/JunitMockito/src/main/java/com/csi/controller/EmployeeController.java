package com.csi.controller;


import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("/saveData")
    public ResponseEntity<?>saveData(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveData(employee), HttpStatus.CREATED);
    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<Employee>>getAllData(){
        return ResponseEntity.ok(employeeService.getAllData());
    }

    @GetMapping("/getDataById/{empId}")
    public ResponseEntity<Employee>getDataById(@PathVariable int empId){
        return ResponseEntity.ok(employeeService.getDataById(empId).orElseThrow(()->new RecordNotFoundException("Id does not exist")));
    }

    @PutMapping("/updateData/{empId}")
    public ResponseEntity<Employee>updateData(@Valid @PathVariable int empId,@RequestBody Employee employee){
        Employee employee1=employeeService.getDataById(empId).orElseThrow(()->new RecordNotFoundException("id Dose NOt Exist"));

        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpDob(employee.getEmpDob());
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpId(employee.getEmpId());
        employee1.setEmpContact(employee.getEmpContact());

        return ResponseEntity.ok(employeeService.updateData(employee1));



    }
    @DeleteMapping("/deleteById/{empId}")
    public ResponseEntity<String >deleteById(@PathVariable int empId){

        employeeService.deleteDataById(empId);

        return ResponseEntity.ok("Id deleted Successfully");
    }
}
