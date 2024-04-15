package io.github.com.dudupuci.structure.data.utils;

public abstract class PasswordGenerator {
    private static final Integer MAX_PER_DAY = 999;

    public static String generate() {
        var base = "000";
        var password = "";
        for (int i = 0; i < MAX_PER_DAY; i++) {
            password = base + i;
        }
        return password;
    }
}
