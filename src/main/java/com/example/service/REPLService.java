package com.example.service;

import com.example.model.CommandInput;
import com.example.model.CommandOutput;
import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class REPLService {
    private static JShell jsSHELL = JShell.builder().build();;

    public List<CommandOutput> executeCommand(CommandInput commandInput) {
        List<SnippetEvent> snippetEvents = jsSHELL.eval(commandInput.getCommand());
        return snippetEvents.stream().map(
                event -> new CommandOutput(event)
        ).collect(Collectors.toList());
    }
}
