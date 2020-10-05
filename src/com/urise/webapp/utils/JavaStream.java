package com.urise.webapp.utils;

import java.util.*;
import java.util.stream.Collectors;

public class JavaStream {

    public static void main(String[] args) {
        int[] array = new int[]{9, 5, 1, 0, 2, 2, 8, 9};
        System.out.println(minValue(array));

        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 9, 1, 2, 4, 5));
        System.out.println(oddOrEven(integers).toString());
    }

    public static int minValue(int[] values) {
        return Arrays.stream(values)
                .distinct()
                .sorted()
                .reduce(0,(a, b) -> 10 * a + b);
    }

    public static List<Integer> oddOrEven(List<Integer> integers) {
        int sum = integers.stream()
                .mapToInt(a -> a)
                .sum();
        System.out.println("Сумма чисел коллекции = " + sum);
        return integers.stream().filter(a -> (a % 2) != sum % 2).collect(Collectors.toList());
    }
}
