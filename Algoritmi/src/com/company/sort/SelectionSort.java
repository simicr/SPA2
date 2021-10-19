package com.company.sort;

public class SelectionSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {

        for (int i = 0; i < arr.length; i++) {
            T tmpMin = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (tmpMin.compareTo(arr[j]) > 0)
                    tmpMin = arr[j];
            }
            arr[i] = tmpMin;
        }

    }
}
