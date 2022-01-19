package com.epam.spring.homework1.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Pet {
    @Autowired
    private List<Animal> animals;

    @Autowired
    public void addPet(@Qualifier("petCheetah") Cheetah pet) {
        animals.add(pet);
    }

    public void printPets() {
        for (Animal animal: animals) {
            System.out.println(animal);
        }
    }
}