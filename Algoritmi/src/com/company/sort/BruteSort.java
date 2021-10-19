package com.company.sort;


public class BruteSort {

    public static <T extends Comparable<T>> void sort(T  [] niz){
        for(int i = 0; i < niz.length; i++)
            for(int j = i; j < niz.length; j++){
                if(niz[i].compareTo(niz[j]) > 0 ){
                    T pom = niz[i];
                    niz[i] = niz[j];
                    niz[j] = pom;
                }
            }
    }
}
