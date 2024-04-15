package io.github.com.dudupuci.structure.data.entities;

public class Child {
    private String name;

    public Child(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String talkHotPotato() {
        return "Hot potato, hot, hot...";
    }

    public String burn(Child child) {
        return "Burn! " + child.getName();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
