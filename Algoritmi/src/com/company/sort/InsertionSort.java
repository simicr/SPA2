package com.company.sort;

public class InsertionSort {
    public static <T extends Comparable<T>> void sort(T  [] niz){

        for(int i = 1; i < niz.length; i++){
            if(niz[i].compareTo(niz[i-1]) >= 0){
                T pom = niz[i];
                int j = i - 1;
                while(j >= 0 && pom.compareTo(niz[j]) < 0 ){
                    niz[j+1] = niz[j];
                    j--;
                }
                niz[j] = pom;
            }
        }

    }
}
