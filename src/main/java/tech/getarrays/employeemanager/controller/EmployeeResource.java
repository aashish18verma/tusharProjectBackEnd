package tech.getarrays.employeemanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.*;
import tech.getarrays.employeemanager.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeResource {

    public final EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable ("id") Long id) throws Throwable {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.addEmployee(employee);
        return  new ResponseEntity<>(employee1,HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return  new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }

    @PutMapping("/update-q1/{id}")
    public ResponseEntity<Employee> updateEmployeeQ1(@PathVariable ("id") Long id ,@RequestBody Q1Rating q1Rating) throws Throwable {
        Employee updateQ1Employee = employeeService.findEmployeeById(id);
        q1Rating.setAvg(createAvg(q1Rating.getAttendance(), q1Rating.getPresentation(),q1Rating.getStudentsAssessment(),q1Rating.getTargetsAchieved()));
        q1Rating.setId(id);
        updateQ1Employee.setQ1Rating(q1Rating);
        Employee updateEmployee = employeeService.updateEmployee(updateQ1Employee);
        return  new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }

    private Integer createAvg(Integer attendance, Integer presentation, Integer studentsAssessment, Integer targetsAchieved) {
        if (attendance == null){
            attendance =0;
        }
        if (presentation == null){
            presentation =0;
        }if (studentsAssessment == null){
            studentsAssessment =0;
        }if (targetsAchieved == null){
            targetsAchieved =0;
        }

        return attendance+presentation+studentsAssessment+targetsAchieved/4;
    }

    @PutMapping("/update-q2/{id}")
    public ResponseEntity<Employee> updateEmployeeQ2(@PathVariable ("id") Long id ,@RequestBody Q2Rating q2Rating) throws Throwable {
        Employee updateQ2Employee = employeeService.findEmployeeById(id);
        q2Rating.setAvg(createAvg(q2Rating.getAttendance() , q2Rating.getPresentation() , q2Rating.getStudentsAssessment() , q2Rating.getTargetsAchieved()));
        q2Rating.setId(id);
        updateQ2Employee.setQ2Rating(q2Rating);
        Employee updateEmployee = employeeService.updateEmployee(updateQ2Employee);
        return  new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }

    @PutMapping("/update-q3/{id}")
    public ResponseEntity<Employee> updateEmployeeQ3(@PathVariable ("id") Long id ,@RequestBody Q3Rating q3Rating) throws Throwable {
        Employee updateQ3Employee = employeeService.findEmployeeById(id);
        q3Rating.setAvg(createAvg(q3Rating.getAttendance(), q3Rating.getPresentation(),q3Rating.getStudentsAssessment(),q3Rating.getTargetsAchieved()));
        q3Rating.setId(id);
        updateQ3Employee.setQ3Rating(q3Rating);
        Employee updateEmployee = employeeService.updateEmployee(updateQ3Employee);
        return  new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }

    @PutMapping("/update-q4/{id}")
    public ResponseEntity<Employee> updateEmployeeQ4(@PathVariable ("id") Long id ,@RequestBody Q4Rating q4Rating) throws Throwable {
        Employee updateQ4Employee = employeeService.findEmployeeById(id);
        q4Rating.setAvg(createAvg(q4Rating.getAttendance(), q4Rating.getPresentation(),q4Rating.getStudentsAssessment(),q4Rating.getTargetsAchieved()));
        q4Rating.setId(id);
        updateQ4Employee.setQ4Rating(q4Rating);
        Employee updateEmployee = employeeService.updateEmployee(updateQ4Employee);
        return  new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }

    @GetMapping("/q1all")
    public ResponseEntity<List<Employee>> getQ1Employees(){
        List<Employee> employees = employeeService.findAllQ1Employee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/q2all")
    public ResponseEntity<List<Employee>> getQ2Employees(){
        List<Employee> employees = employeeService.findAllQ2Employee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/q3all")
    public ResponseEntity<List<Employee>> getQ3Employees(){
        List<Employee> employees = employeeService.findAllQ3Employee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/q4all")
    public ResponseEntity<List<Employee>> getQ4Employees(){
        List<Employee> employees = employeeService.findAllQ4Employee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable ("id") Long id){
        employeeService.deleteEmployee(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginRequest> login(@RequestBody  LoginRequest loginRequest){
        if (loginRequest.getUsername().equals("tushar@gmail.com") && loginRequest.getPassword().equals("password")){
            return  new ResponseEntity<>(loginRequest,HttpStatus.OK);
        }
        else{
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    }




}
