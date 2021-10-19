package com.company.sort;

public class Bogosort {

    public static <T extends Comparable<T>> boolean sorted(T[] arr) {

        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        return true;
    }

    public static <T extends Comparable<T>> void shuffle(T[] arr) {

        for (int i = arr.length - 1; i > 0; i--) {
            int random = (int) (Math.random() * i);

            T help = arr[i];
            arr[i] = arr[random];
            arr[random] = help;
        }
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        long start = System.currentTimeMillis();
        while (!sorted(arr))
            shuffle(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }
}
