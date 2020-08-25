package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "employees") //@Table annotation maps the entity with the table.
public class EmployeeModel {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private SalaryModel salaryModel;
    private DepartmentModel departmentModel;

    public EmployeeModel() {

    }

    public EmployeeModel(String firstName, String lastName, String email, SalaryModel salaryModel, DepartmentModel departmentModel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salaryModel = salaryModel;
        this.departmentModel = departmentModel;
    }
    //    public EmployeeModel(String firstName, String lastName, String email, SalaryModel salaryModel) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.salaryModel = salaryModel;
//    }

//    public EmployeeModel(String firstName, String lastName, String email) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//    }

    @Id //@Id annotation specifies the primary key of an entity.
    @GeneratedValue(strategy = GenerationType.AUTO) //@GeneratedValue provides for the specification of generation strategies for the values of primary keys.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL) //@OneToOne annotation defines a one-to-one relationship with another entity.
    @JoinColumn(name = "job_Profile") //@JoinColumn indicates that this entity is the owner of the relationship (that is: the corresponding table has a column with a foreign key to the referenced table).
    public SalaryModel getSalaryModel() {
        return salaryModel;
    }

    public void setSalaryModel(SalaryModel salaryModel) {
        this.salaryModel = salaryModel;
    }

    @Column(name = "first_name", nullable = false)  //@Column application maps the entity’s field with the table’s column.
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id")
    public DepartmentModel getDepartmentModel() {
        return departmentModel;
    }

    public void setDepartmentModel(DepartmentModel departmentModel) {
        this.departmentModel = departmentModel;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + "]";
    }

}
