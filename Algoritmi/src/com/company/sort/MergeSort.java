package com.company.sort;

import java.util.LinkedList;

public class MergeSort {


    public static <T extends Comparable<T>> void combine(T[] arr, int l, int h,int mid){

        int indexL = l;
        int indexR = mid + 1;

        LinkedList<T> list = new LinkedList<T>();

        while(indexL <= mid && indexR <=h){
            if(arr[indexL].compareTo(arr[indexR]) <= 0){
                list.add(arr[indexL]);
                indexL++;
            } else {
                list.add(arr[indexR]);
                indexR++;
            }
        }

        while(indexL <= mid){
            list.add(arr[indexL]);
            indexL++;
        }

        while(indexR <= h){
            list.add(arr[indexR]);
            indexR++;
        }

        for(int i = l; i <= h; i++){
            arr[i] = list.remove();
        }

    }
    public static <T extends Comparable<T>> void sort(T[] arr, int l, int h){
        if(l < h){
            int mid = (l+h)/2;
            sort(arr, l, mid);
            sort(arr, mid +1, h);
            combine(arr, l ,h,mid);
        }
    }
    public static <T extends Comparable<T>> void sort(T[] arr){
        sort(arr,0,arr.length-1);
    }
}
