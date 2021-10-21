package com.company.sort;

public class ShellSort{

    public static <T extends Comparable<T>> void sort(T[] arr){
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};

        for ( int k  : gaps) {

            if( k <= arr.length){

                for(int i = 0; i < k; i++){

                    for(int j = i +k; j < arr.length; j +=k ){
                        T tmp = arr[j];
                        int prevIndex = j - k;
                        while(prevIndex >= 0 && tmp.compareTo(arr[prevIndex]) < 0){
                                arr[prevIndex + k] = arr[prevIndex];
                                prevIndex -= k;
                        }
                        arr[prevIndex + k] = tmp;
                    }
                }

            }
        }
    }
}
