package com.vicky;

public interface AnimalService {
    Animals create(String name, String commands, AnimalType type);

    String getCommands(String name);

    void learnNewCommands(String name, String commands);
}
