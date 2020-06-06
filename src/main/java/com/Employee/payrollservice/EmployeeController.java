package com.Employee.payrollservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    private EmployeeRepository repository;
    EmployeeController(EmployeeRepository repository){
        this.repository = repository;
    }
    @GetMapping("/employees")
    List<Employee> all(){
        return repository.findAll();
    }
    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id){
        return repository.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee employee){
        return repository.save(employee);
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee employee,@PathVariable Long id){
        return repository.findById(id).map(employee1->{employee1.setId(employee.getId());
        employee1.setName(employee.getName());
        employee1.setPosition(employee.getPosition());
        return repository.save(employee1);}).orElseGet(()->{employee.setId(id);
        return repository.save(employee);});
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable long id){
        repository.deleteById(id);
    }


}
