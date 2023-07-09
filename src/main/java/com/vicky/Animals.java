package com.vicky;

import java.util.ArrayList;
import java.util.List;

public abstract class Animals {
    private String name;
    private List<String> commands = new ArrayList<>();

    protected Animals(String name, List<String> commands) {
        this.name = name;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }
}
