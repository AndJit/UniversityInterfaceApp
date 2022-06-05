package dev.testapp.UniversityInterface.commands;

import dev.testapp.UniversityInterface.entities.Department;
import dev.testapp.UniversityInterface.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetHeadDepartmentCommand implements Command{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void execute(String arg) {
        Department department = departmentRepository.findDepartmentByName(arg);
        if (department == null) return;
        System.out.printf("Head of %s department is %s", arg, department.getHeadOfDepartment().getName());
    }

    @Override
    public String getKey() {
        return "Who is head of department (\\w+)";
    }
}
