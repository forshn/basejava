package com.urise.webapp.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStream {

    public static void main(String[] args) {
        int[] array = new int[]{9, 8, 8, 7, 5, 4, 3, 3, 2, 1, 0};
        System.out.println(minValue(array));

        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 9, 1, 2, 4, 5));
        System.out.println(oddOrEven(integers).toString());
    }

    public static int minValue(int[] values) {
        int result = 0;
        int num = (Arrays.stream(values)
                .distinct()
                .reduce(0, (a, b) -> 10 * a + b));
        while (num != 0) {
            int digit = num % 10;
            result = result * 10 + digit;
            num /= 10;
        }
        return result;
    }

    public static List<Integer> oddOrEven(List<Integer> integers) {
        int sum = integers.stream()
                .mapToInt(a -> a)
                .sum();
        System.out.println("Сумма чисел коллекции = " + sum);
        return integers.stream().filter(a -> (a % 2) != sum % 2).distinct().collect(Collectors.toList());
    }
}
