package com.learningvboot.teja.tejaspringboot.Controller;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import com.learningvboot.teja.tejaspringboot.Entity.Employee;
import com.learningvboot.teja.tejaspringboot.Repository.EmployeeRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRespository ems;

    @GetMapping("/employee")
    public ResponseEntity<Optional<Employee>> getEmployee(@RequestParam Long id){

       Optional<Employee> em= ems.findById(id);

       return new ResponseEntity<>(em,HttpStatus.OK);

    }


    @GetMapping("/allemployee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employess = new ArrayList<>();
        employess= ems.findAll();
       return new ResponseEntity<>(employess,HttpStatus.OK);

    }


    @PostMapping("/save")
    public ResponseEntity<Long> saveEmployee(@RequestBody Employee employee){

       Employee emp = ems.save(employee);
        return new ResponseEntity<Long>(emp.getId(),HttpStatus.OK);

    }
    
}
