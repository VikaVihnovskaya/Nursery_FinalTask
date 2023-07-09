package com.vicky;

import java.util.HashMap;
import java.util.Map;

public class DefaultAnimalRepository implements AnimalRepository {

    private final Map<String, Animals> animalsMap = new HashMap<>();

    @Override
    public void save(Animals animals) {
        animalsMap.put(animals.getName(), animals);
    }

    @Override
    public Animals findByName(String name) {
        return animalsMap.get(name);
    }
}
