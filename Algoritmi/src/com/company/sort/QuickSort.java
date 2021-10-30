package com.company.sort;

public class QuickSort {

        private static <T extends Comparable<T>> int partition(T[] arr, int l, int h){
            T pivot = arr[l];

            int i = l+1;
            int j = h;
            while(i <= j){
                while(i <= h && arr[i].compareTo(pivot) < 0 ) i++;
                while(j >= l+1 && arr[j].compareTo(pivot) > 0 ) j--;

                if(i <= j) {
                    T tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;

                    i++;
                    j--;
                }

            }
            T tmp = arr[l];
            arr[l] = arr[j];
            arr[j] = tmp;

            return j;
        }
        private static <T extends Comparable<T>> void sort(T[] arr, int l, int h){
            if(l >= h){
                return;
            }
            int j = partition(arr,l,h);
            sort(arr, l, j-1);
            sort(arr, j + 1, h);
        }
        public static <T extends Comparable<T>> void sort(T[] arr){
            sort(arr, 0, arr.length-1);
        }
}
