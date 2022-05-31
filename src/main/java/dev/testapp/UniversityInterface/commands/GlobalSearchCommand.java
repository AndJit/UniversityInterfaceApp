package dev.testapp.UniversityInterface.commands;

import dev.testapp.UniversityInterface.repositories.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class GlobalSearchCommand implements Command {

    @Autowired
    private LectorRepository lectorRepository;

    @Override
    public void execute(String arg) {
        ArrayList<String> names = new ArrayList<>();
        lectorRepository.findAll().forEach(lector -> {
            String lectorName = lector.getName();
            if (lectorName.contains(arg)) names.add(lectorName);
        });
        System.out.println(String.join(", ", names));
    }

    @Override
    public String getKey() {
        return "Global search by %";
    }
}
