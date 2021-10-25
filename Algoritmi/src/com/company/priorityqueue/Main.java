package com.company.priorityqueue;

public class Main {
    public static void main(String[] args) {

        Heap p = new Heap();
        int[] arr = {1,2,3,7,17,19,25,36,100};
        for (int i = 0; i < arr.length; i++) {
            p.appendNew(arr[i]);
        }
        System.out.println(p);
        p.deleteMax();
        System.out.println(p);
        Integer m = p.minElem();
        System.out.println(m);


    }
}
