package com.company.sort;

public class Bogosort {

    public static <T extends Comparable<T>> boolean sorted(T  [] niz) {
            boolean result=true;
            for(int i = 0; i < niz.length-1; i++)
                if(niz[i].compareTo(niz[i+1]) > 0)
                    result = false;
            return result;
    }

    public static <T extends Comparable<T>> void shuffle(T  [] niz){

            for( int i = niz.length - 1; i > 0; i--){
                    int random = (int)(Math.random()*i);

                    T help = niz[i];
                    niz[i] = niz[random];
                    niz[random] = help;
            }
    }
    public static <T extends Comparable<T>> void sort(T[] niz){
            long start = System.currentTimeMillis();
            while(!sorted(niz))
                shuffle(niz);
            long end = System.currentTimeMillis();
            System.out.println(end - start + "ms");
    }
}
