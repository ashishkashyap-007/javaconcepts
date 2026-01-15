package com.ashish.java.concepts.generics;

interface Flyer {
    void fly();
}

interface Swimmer {
    void swim();
}

class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Duck extends Animal implements Flyer, Swimmer {

    @Override
    public void fly() {
        System.out.println("Duck is flying");
    }

    @Override
    public void swim() {
        System.out.println("Duck is swimming");

    }
}

public class MultiBoundTypeParameterExample<T extends Animal & Flyer & Swimmer> {
    private T creature;

    public MultiBoundTypeParameterExample(T creature) {
        this.creature = creature;
    }

    public void showAbilities() {
        creature.eat();
        creature.fly();
        creature.swim();
    }

    static void main() {
        Duck duck = new Duck();
        MultiBoundTypeParameterExample<Duck> duckEaxample = new MultiBoundTypeParameterExample<>(duck);
        duckEaxample.showAbilities();
    }
}
