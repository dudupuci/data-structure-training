package io.github.com.dudupuci.structure.data.entities;

import io.github.com.dudupuci.structure.data.enums.Priority;

public class Person  {
    private String name;
    private final Priority priority;
    private final String password;

    public Person(Priority priority, String password) {
        this.priority = priority;
        this.password = password;
    }

    public Person(String name, Priority priority, String password) {
        this.name = name;
        this.priority = priority;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}
