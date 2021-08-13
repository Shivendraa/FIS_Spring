package com.fis.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.stream.Stream;

@Component
class EmployeeInitializer implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public EmployeeInitializer(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.save(new Employee("Rajesh", 30000.0));
        employeeRepository.save(new Employee("Rakesh", 50000.0));
        employeeRepository.save(new Employee("Somesh", 40000.0));
        employeeRepository.save(new Employee("Mukesh", 35000.0));
        employeeRepository.save(new Employee("Radhesh", 45000.0));
        
        employeeRepository.findAll().forEach(System.out::println);
    }
}