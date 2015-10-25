package org.stepic.java;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Mikhail Valeyko on 25/10/2015.
 */
public class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        try {
            ObjectInputStream stream = new ObjectInputStream(new ByteArrayInputStream(data));
            int count = stream.readInt();
            Animal[] animals = new Animal[count];
            for (int i = 0; i < count; i++) {
                animals[i] = (Animal) stream.readObject();
            }
            return animals;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
