package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "Department")
public class DepartmentModel {

    private int departmentId;

    private String departmentName;

    private String departmentLocation;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_Id")
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Column(name = "department_Name")
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Column(name = "department_Location")
    public String getDepartmentLocation() {
        return departmentLocation;
    }

    public void setDepartmentLocation(String departmentLocation) {
        this.departmentLocation = departmentLocation;
    }
}
