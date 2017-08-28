package com.example.rest;

import com.example.model.CommandInput;
import com.example.model.CommandOutput;
import com.example.service.REPLService;
import jdk.jshell.SnippetEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Map.of;

/**
 * Created by venkateswara on 7/16/17.
 */
@RestController
public class REPLController {

    @Autowired
    REPLService replService;
    @RequestMapping(value = "/repl", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommandOutput>> replCommand(@RequestBody CommandInput commandInput) {
        List<CommandOutput> response = replService.executeCommand(commandInput);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
