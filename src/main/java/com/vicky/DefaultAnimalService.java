package com.vicky;

import com.vicky.exception.AnimalsNotFoundException;
import com.vicky.exception.AnimalsWithSameNameExistedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultAnimalService implements AnimalService {
    private final AnimalRepository animalRepository;

    public DefaultAnimalService() {
        this.animalRepository = new DefaultAnimalRepository();
    }

    @Override
    public Animals create(String name, String commands, AnimalType type) {
        Animals existingAnimals = animalRepository.findByName(name);
        if (existingAnimals != null) {
            throw new AnimalsWithSameNameExistedException("Животное с таким именем уже существует");
        }
        List<String> listCommands = Arrays.asList(commands.split(","));
        Animals animals = null;
        switch (type) {
            case CAT:
                animals = new Cats(name, listCommands);
                break;
            case DOG:
                animals = new Dogs(name, listCommands);
                break;
            case HAMSTER:
                animals = new Hamsters(name, listCommands);
                break;
            case CAMEL:
                animals = new Camels(name, listCommands);
                break;
            case HORSE:
                animals = new Horses(name, listCommands);
                break;
            case DONKEY:
                animals = new Donkeys(name, listCommands);
                break;
        }
        animalRepository.save(animals);
        return animals;
    }

    @Override
    public String getCommands(String name) {
        Animals animals = animalRepository.findByName(name);
        if (animals == null) {
            throw new AnimalsNotFoundException("Животное не найдено");
        }
        return String.join(",", animals.getCommands());
    }

    @Override
    public void learnNewCommands(String name, String commands) {
        Animals animals = animalRepository.findByName(name);
        if (animals == null) {
            throw new AnimalsNotFoundException("Животное не найдено");
        }
        List<String> newCommands = new ArrayList<>(Arrays.asList(commands.split(",")));
        newCommands.addAll(animals.getCommands());
        animals.setCommands(newCommands);
    }
}
