package io.github.com.dudupuci.structure.data.utils;

import io.github.com.dudupuci.structure.data.enums.Priority;

import java.util.Random;

public abstract class PriorityGenerator {
    public static Priority generate() {
        var priorities = Priority.values();
        var random = new Random();
        return priorities[random.nextInt(priorities.length)];
    }
}
