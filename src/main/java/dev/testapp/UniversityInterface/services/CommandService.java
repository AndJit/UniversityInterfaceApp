package dev.testapp.UniversityInterface.services;

import dev.testapp.UniversityInterface.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static dev.testapp.UniversityInterface.utils.Util.wordNum;

@Service
public class CommandService {

    @Autowired
    private List<Command> commands;

    public String getParam(String input, String commandKey){
        String param = null;

        String[] commandWords = commandKey.split(" ");
        String[] inputWords = input.split(" ");

        if (inputWords.length == commandWords.length){
            int paramIndex = wordNum(commandWords, "%");
            String vParam = inputWords[paramIndex];
            inputWords[paramIndex] = "%";
            if(Arrays.equals(inputWords,commandWords)) param = vParam;
        }
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
