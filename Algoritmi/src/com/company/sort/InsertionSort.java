package com.company.sort;

public class InsertionSort {
    public static <T extends Comparable<T>> void sort(T[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[i - 1]) >= 0) {
                T help = arr[i];
                int j = i - 1;
                while (j >= 0 && help.compareTo(arr[j]) < 0) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j] = help;
            }
        }

    }
}
