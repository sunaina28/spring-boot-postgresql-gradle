package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeesController {
    @Autowired
    EmployeesRepo employeesRepo;

    @Autowired
    SalaryRepo salaryRepo;

    //get Employees
    @RequestMapping(value = "/getAllEmployee",method = RequestMethod.GET)
    public List<EmployeeModel>getAllEmployee() {
        return this.employeesRepo.findAll();
    }

    //get Employee by id
    @RequestMapping(value = "/getEmployeeById",method = RequestMethod.GET)
    public ResponseEntity<EmployeeModel> getEmployeeById (@RequestParam int employeeId)throws ResourceNotFoundException {
        EmployeeModel emp = employeesRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(emp);
    }

    //save Employee
    @RequestMapping(value = "/createEmployee",method = RequestMethod.POST)
    public EmployeeModel createEmployee(@RequestBody EmployeeModel employeeModel){
        return employeesRepo.save(employeeModel);
    }


    //update Employee //issue
    @RequestMapping(value = "/updateEmployee",method = RequestMethod.PUT)
    public EmployeeModel updateEmployee(@RequestParam int employeeId,
                                        @RequestBody EmployeeModel employeeDetails) throws ResourceNotFoundException {
        EmployeeModel employee = employeesRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmail(employeeDetails.getEmail());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setSalaryModel(employeeDetails.getSalaryModel());
        employee.setSalaryModel(employeeDetails.getSalaryModel());

        return employeesRepo.save(employee);
    }



//    //update Employee //issue
//    @RequestMapping(value = "/updateEmployee",method = RequestMethod.PUT)
//    public ResponseEntity<EmployeeModel> updateEmployee(@RequestParam int employeeId,
//                                                        @RequestBody EmployeeModel employeeDetails) throws ResourceNotFoundException {
//        EmployeeModel employee = employeesRepo.findById(employeeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//        employee.setEmail(employeeDetails.getEmail());
//        employee.setLastName(employeeDetails.getLastName());
//        employee.setFirstName(employeeDetails.getFirstName());
//        final EmployeeModel updatedEmployee = employeesRepo.save(employee);
//        return ResponseEntity.ok(updatedEmployee);
//    }


    //delete Employee
    @RequestMapping(value = "/deleteEmployee",method = RequestMethod.DELETE)
    public Map<String,Boolean> deleteEmployee(@RequestParam int employeeId) throws ResourceNotFoundException {
        EmployeeModel emp = employeesRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("employee not found for this id :: " + employeeId));
        this.employeesRepo.delete(emp);

        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }

    //get Salary Detail
    @RequestMapping(value = "/getSalaryDetail",method = RequestMethod.GET)
    public List<SalaryModel>getSalaryDetail() {
        return this.salaryRepo.findAll();
    }

//    // Store Salary Detail
//    @RequestMapping(value = "/storeSalaryDetail",method = RequestMethod.POST)
//    public SalaryModel storeSalaryDetail(@RequestBody SalaryModel salaryModel){
//        return salaryRepo.save(salaryModel);
//    }
//
//    //Find Salary Detail by Job-Name
//    @RequestMapping(value = "/findSalaryByJobName",method = RequestMethod.GET)
//    public SalaryModel findSalaryByJobName(@RequestParam String jobName){
//        SalaryModel salaryModel = findSalaryByJobName(jobName);
//        return salaryModel;
//    }

}
