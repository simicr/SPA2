package com.company.sort;

public class BubbleSort {
    public static <T extends  Comparable<T>> void sort(T  [] niz){
        for (int i = niz.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if(niz[j].compareTo(niz[j+1]) >0){
                    T help = niz[j];
                    niz[j] = niz[j+1];
                    niz[j+1] = help;
                }
            }
        }
    }
}
