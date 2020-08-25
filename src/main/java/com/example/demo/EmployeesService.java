package com.example.demo;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeesService {

    EmployeeModel createEmployee(EmployeeModel employeeModel);

    List<EmployeeModel> getAllEmployee();

    ResponseEntity<EmployeeModel> getEmployeeById(int employeeId) throws ResourceNotFoundException;

    EmployeeModel updateEmployee(int employeeId, EmployeeModel employeeDetails) throws ResourceNotFoundException;

    Map<String, Boolean> deleteEmployee(int employeeId) throws ResourceNotFoundException;

    List<SalaryModel> getSalaryDetail();

    SalaryModel findSalaryByJobName(String jobName);

    ResponseEntity<DepartmentModel> findDepartmentById(int deptId) throws ResourceNotFoundException;
}
