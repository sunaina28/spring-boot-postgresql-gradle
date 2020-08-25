package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeesController {

    @Autowired
    EmployeesService employeesService;

    //save Employee
    @RequestMapping(value = "/createEmployee",method = RequestMethod.POST)
    public EmployeeModel createEmployee(@RequestBody EmployeeModel employeeModel){
        return employeesService.createEmployee(employeeModel);
    }

    //get Employees
    @RequestMapping(value = "/getAllEmployee",method = RequestMethod.GET)
    public List<EmployeeModel>getAllEmployee() {
        return employeesService.getAllEmployee();
    }

    //get Employee by id
    @RequestMapping(value = "/getEmployeeById",method = RequestMethod.GET)
    public ResponseEntity<EmployeeModel> getEmployeeById (@RequestParam int employeeId)throws ResourceNotFoundException {
        return employeesService.getEmployeeById(employeeId);
    }

    //update Employee
    @RequestMapping(value = "/updateEmployee",method = RequestMethod.PUT)
    public EmployeeModel updateEmployee(@RequestParam int employeeId,
                                        @RequestBody EmployeeModel employeeDetails) throws ResourceNotFoundException {
        return employeesService.updateEmployee(employeeId,employeeDetails);
    }


    //delete Employee
    @RequestMapping(value = "/deleteEmployee",method = RequestMethod.DELETE)
    public Map<String,Boolean> deleteEmployee(@RequestParam int employeeId) throws ResourceNotFoundException {
        return employeesService.deleteEmployee(employeeId);
    }

    //get Salary Detail
    @RequestMapping(value = "/getSalaryDetail",method = RequestMethod.GET)
    public List<SalaryModel>getSalaryDetail() {
        return employeesService.getSalaryDetail();
    }

    //Find Salary Detail by Job-Name
    @RequestMapping(value = "/findSalaryByJobName",method = RequestMethod.GET)
    public SalaryModel findSalaryByJobName(@RequestParam String jobName){
        return employeesService.findSalaryByJobName(jobName);
    }

    //Find Department by id
    @RequestMapping(value = "/findDepartmentById",method = RequestMethod.GET)
    public ResponseEntity<DepartmentModel> findDepartmentById (@RequestParam int deptId)throws ResourceNotFoundException {
        return employeesService.findDepartmentById(deptId);
    }

}
