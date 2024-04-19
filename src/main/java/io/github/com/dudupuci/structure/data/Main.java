package io.github.com.dudupuci.structure.data;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var numbers = showNumbers();
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

    private static List<Integer> showNumbers() {
        var numbers = new ArrayList<Integer>();
        for (int i = 1000; i <= 1999; i++) {
            if (i % 11 == 5) {
                numbers.add(i);
            }
        }
        return numbers;
    }
}
