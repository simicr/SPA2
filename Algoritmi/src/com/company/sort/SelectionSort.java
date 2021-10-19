package com.company.sort;

public class SelectionSort {

    public static <T extends Comparable<T>> void sort(T  [] niz){

        for(int i = 0; i < niz.length; i++ ){
            T tmpMin = niz[i];
            for(int j = i; j < niz.length; j++){
                if( tmpMin.compareTo(niz[j]) > 0 )
                    tmpMin = niz[j];
            }
            niz[i] = tmpMin;
        }

    }
}
