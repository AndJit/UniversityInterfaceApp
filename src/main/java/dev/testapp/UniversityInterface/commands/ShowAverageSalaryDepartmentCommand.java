package dev.testapp.UniversityInterface.commands;

import antlr.collections.impl.LList;
import dev.testapp.UniversityInterface.entities.Department;
import dev.testapp.UniversityInterface.entities.Lector;
import dev.testapp.UniversityInterface.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowAverageSalaryDepartmentCommand implements Command{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void execute(String arg) {
        Department department = departmentRepository.findDepartmentByName(arg);
        if (department == null) return;
        List<Lector> lectors  = department.getLectors();
        int i = 0;
        double salaries = 0;
        for (; i < lectors.size(); i++) {
            salaries += lectors.get(i).getSalary();
        }
        System.out.printf("The average salary of %s is %f", arg, salaries/i);
    }

    @Override
    public String getKey() {
        return "Show the average salary for the department %";
    }
}
