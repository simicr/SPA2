package com.company.priorityqueue;

public class Main {
    public static void main(String[] args) {

        Heap p = new Heap();
        for (int i = 15; i >= 0; i--) {
            Integer pom = 15 - i;
            p.appendNew(pom);
        }
        //p.appendNew(16);

        System.out.println(p);
    }
}
