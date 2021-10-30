package com.company.sort;

public class HeapSort {

    private static <T extends Comparable<T>> void makeHeap(T[] arr, int start, int end){
        int parentIndex = start;
        boolean restored = false;

        while(!restored){

            int greaterSon = getGreaterSon(arr, parentIndex, end);

            if(greaterSon == -1 ){
                restored = true;
            } else {
                if(arr[parentIndex].compareTo(arr[greaterSon]) < 0){
                    T tmp = arr[parentIndex];
                    arr[parentIndex] = arr[greaterSon];
                    arr[greaterSon] = tmp;
                    parentIndex = greaterSon;
                } else {
                    restored = true;
                }
            }
        }
    }
    private static <T extends  Comparable<T>> int getGreaterSon(T[] arr, int parent, int end){
        int son1 = 2*parent +1;
        int son2 = 2*parent +2;

        if(son1 >= end && son2 >= end)
            return -1;
        if(son1 <= end && son2 > end)
            return son1;

        if(arr[son1].compareTo(arr[son2]) > 0)
            return son1;

        return  son2;
    }
    public static <T extends Comparable<T>> void sort(T[] arr){
        int lastParent = (arr.length - 2)/2;

        //we achieve a heap structure on the whole array
        while(lastParent >= 0){
            makeHeap(arr,lastParent,arr.length-1);
            lastParent--;
        }

        int end = arr.length -1;
        while(end > 0){
            T tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            end --;
            makeHeap(arr,0,end);// we restore heap on the rest of the arr

        }

    }
}
