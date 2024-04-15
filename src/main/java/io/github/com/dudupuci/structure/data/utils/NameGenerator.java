package io.github.com.dudupuci.structure.data.utils;

import java.util.List;
import java.util.Random;

public class NameGenerator {
    private static final List<String> names = List.of(
            "Eduardo",
            "Pedro",
            "Roberto",
            "Carlos",
            "Amanda",
            "Rodrigo",
            "João",
            "Antônio",
            "Suzana",
            "Carla",
            "Ricardo",
            "Miranda",
            "Wagner",
            "Luan",
            "Lucas",
            "Damilly",
            "Isabel",
            "Isabela",
            "Izabelle",
            "Lorena",
            "Higor",
            "Yuri",
            "Ian",
            "Gustavo",
            "Rebeca",
            "Gabriel",
            "Bryan",
            "Josué",
            "José",
            "Silvana",
            "Heitor",
            "Enzo",
            "Paulo",
            "Ana"
    );

    public static String generate() {
        var random = new Random();
        int index = random.nextInt(names.size());
        return names.get(index);
    }
}