package com.example.demo;

import javax.persistence.*;

@Entity //@Entity annotation specifies that the class is an entity and is mapped to a database table.
@Table(name = "Salary") //@Table annotation specifies the name of the database table to be used for mapping.
public class SalaryModel {
//    private int id;
    private int salary;
    private String jobName;
//    private EmployeeModel employeeModel;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    @Column(name = "Salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Id
    @Column(name = "Job_Name")
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

//    @OneToOne(mappedBy = "salaryModel") // mappedBy indicates that the entity in this side is the inverse of the relationship, and the owner resides in the “other” entity.
//    public EmployeeModel getEmployeeModel() {
//        return employeeModel;
//    }
//
//    public void setEmployeeModel(EmployeeModel employeeModel) {
//        this.employeeModel = employeeModel;
//    }
}
