package com.vicky;

public interface AnimalRepository {
    void save(Animals animals);
    Animals findByName(String name);

}
