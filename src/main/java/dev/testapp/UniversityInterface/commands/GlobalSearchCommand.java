package dev.testapp.UniversityInterface.commands;

import dev.testapp.UniversityInterface.entities.Lector;
import dev.testapp.UniversityInterface.repositories.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class GlobalSearchCommand implements Command {

    @Autowired
    private LectorRepository lectorRepository;

    @Override
    public void execute(String arg) {
        ArrayList<String> names = (ArrayList<String>) lectorRepository.findAll().stream().filter(lector -> {
            String lectorName = lector.getName();
            if (lectorName != null) return lectorName.contains(arg);
            return false;
        }).map(Lector::getName).collect(Collectors.toList());
        System.out.println(String.join(", ", names));
    }

    @Override
    public String getKey() {
        return "Global search by %";
    }
}
