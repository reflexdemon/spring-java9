package com.example.model;

import jdk.jshell.SnippetEvent;

public class CommandOutput {

    private final SnippetEvent snippetEvent;

    public CommandOutput(SnippetEvent snippetEvent) {
        this.snippetEvent = snippetEvent;
    }

    public String getSnippet() {
        return this.snippetEvent.snippet().toString();
    }

    public String getValue() {
        return this.snippetEvent.value();
    }

    public String getStatus() {
        return this.snippetEvent.status().toString();
    }

    public Throwable getException() {
        return this.snippetEvent.exception();
    }

}
