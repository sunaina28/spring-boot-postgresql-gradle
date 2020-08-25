package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeesServiceImpl implements EmployeesService{
    @Autowired
    EmployeesRepo employeesRepo;

    @Autowired
    SalaryRepo salaryRepo;

    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public EmployeeModel createEmployee(EmployeeModel employeeModel) {
        return employeesRepo.save(employeeModel);
    }

    @Override
    public List<EmployeeModel> getAllEmployee() {
        return this.employeesRepo.findAll();
    }

    @Override
    public ResponseEntity<EmployeeModel> getEmployeeById(int employeeId) throws ResourceNotFoundException {
        EmployeeModel emp = employeesRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(emp);
    }

    @Override
    public EmployeeModel updateEmployee(int employeeId, EmployeeModel employeeDetails) throws ResourceNotFoundException {
        EmployeeModel employee = employeesRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmail(employeeDetails.getEmail());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setSalaryModel(employeeDetails.getSalaryModel());
        employee.setDepartmentModel(employeeDetails.getDepartmentModel());
        return employeesRepo.save(employee);
    }

    @Override
    public Map<String, Boolean> deleteEmployee(int employeeId) throws ResourceNotFoundException {
        EmployeeModel emp = employeesRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("employee not found for this id :: " + employeeId));
        this.employeesRepo.delete(emp);

        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }

    @Override
    public List<SalaryModel> getSalaryDetail() {
        return salaryRepo.findAll();
    }

    @Override
    public SalaryModel findSalaryByJobName(String jobName) {
        SalaryModel salaryModel = salaryRepo.findByJobName(jobName);
        return salaryModel;
    }

    @Override
    public ResponseEntity<DepartmentModel> findDepartmentById(int deptId) throws ResourceNotFoundException {
        DepartmentModel departmentModel = departmentRepo.findById(deptId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + deptId));
        return ResponseEntity.ok().body(departmentModel);
    }
}
