package dev.testapp.UniversityInterface.services;

import dev.testapp.UniversityInterface.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CommandService {

    @Autowired
    private List<Command> commands;

    public String getParam(String input, String commandKey){
        String param = null;
        Pattern pattern = Pattern.compile(commandKey);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) param = matcher.group(1);
        return param;
    }

    public void execute(String s){
        commands.forEach(command -> {
            String key = command.getKey();
            String param = getParam(s, key);
            if (param != null) command.execute(param);
        });
    }

}
