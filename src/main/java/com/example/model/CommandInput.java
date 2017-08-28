package com.example.model;

public class CommandInput {
    private String command;


    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CommandInput{");
        sb.append("command='").append(command).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
