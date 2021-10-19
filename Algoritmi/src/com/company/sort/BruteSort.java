package com.company.sort;


public class BruteSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    T pom = arr[i];
                    arr[i] = arr[j];
                    arr[j] = pom;
                }
            }
    }
}
