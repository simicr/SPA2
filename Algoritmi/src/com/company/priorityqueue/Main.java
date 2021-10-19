package com.company.priorityqueue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Pozdrav");

        PrioretnaLista p = new PrioretnaLista();

        for (int i = 15; i >= 0; i--) {
            Integer pom = 15 - i;
            p.dodaj(i);
        }
        p.dodaj(16);

        System.out.println(p);
    }
}
