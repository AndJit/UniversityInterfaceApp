package dev.testapp.UniversityInterface.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lector")
public class Lector{

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "lectors", fetch = FetchType.EAGER)
    private List<Department> department;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    private Double salary;

    public Lector() {

    }

    public Lector(String name, List<Department> department, Degree degree, Double salary) {
        this.name = name;
        this.department = department;
        this.degree = degree;
        this.salary = salary;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Degree {

        ASSISTANT("assistant"),
        ASSOCIATE_PROFESSOR("associate professor"),
        PROFESSOR("professor");

        String name;

        Degree(String name) {
            this.name = name;
        }

        public String getName(){
            return this.name;
        }
    }

}
