package com.company.sort;

public class Combsort {

    public static <T extends Comparable<T>> void sort(T[] arr){
        boolean done = false;
        int k = arr.length;

        do{
            k = nextGap(k);
            boolean exchOcured = false;

            for(int i = 0; i < arr.length - k; i++){

                if(arr[i].compareTo(arr[i+k]) > 0){
                    T tmp = arr[i];
                    arr[i] = arr[i+k];
                    arr[i+k] = arr[i];
                    exchOcured = true;
                }

            }
            done = k == 1 && !exchOcured;
        }while(!done);

    }
    private static int nextGap(int k){
        k /= 1.3;
        if( k == 9 || k == 10)
            return 11;
        if(k < 1)
            return 1;
        return k;
    }
}
