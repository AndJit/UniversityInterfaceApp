package dev.testapp.UniversityInterface.commands;

import dev.testapp.UniversityInterface.entities.Department;
import dev.testapp.UniversityInterface.entities.Lector;
import dev.testapp.UniversityInterface.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowDepartmentStatisticCommand implements Command{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void execute(String arg) {
        Department department = departmentRepository.findDepartmentByName(arg);
        if (department == null) return;
        List<Lector> lectors = department.getLectors();
        long assistans_count = lectors.stream().filter(lector -> lector.getDegree() == Lector.Degree.ASSISTANT).count();
        long associate_professors_count = lectors.stream().filter(lector -> lector.getDegree() == Lector.Degree.ASSOCIATE_PROFESSOR).count();
        long professors_count = lectors.stream().filter(lector -> lector.getDegree() == Lector.Degree.PROFESSOR).count();
        System.out.println("assistans  " + assistans_count);
        System.out.println("associate professors " + associate_professors_count);
        System.out.println("professors " + professors_count);
    }

    @Override
    public String getKey() {
        return "Show (\\w+) statistics";
    }
}
