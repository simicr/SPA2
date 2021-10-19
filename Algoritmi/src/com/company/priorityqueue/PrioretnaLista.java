package com.company.priorityqueue;

import java.util.*;

public class PrioretnaLista {
    private final static int DEFAULT = 100;

    private ArrayList<Integer> prioretna;

    public PrioretnaLista(int duzina) {
        this.prioretna = new ArrayList<Integer>(duzina);
    }

    public PrioretnaLista() {
        this(DEFAULT);
    }

    public String toString() {
        return prioretna.toString();
    }

    public void dodaj(Integer novi) {
        prioretna.add(novi);
        povratiPravilnost(prioretna.size() - 1);
    }

    private void povratiPravilnost(int indeksSin) {
        int indeksRod = (indeksSin - 1) / 2;

        Integer roditelj = prioretna.get(indeksRod);
        Integer sin = prioretna.get(indeksSin);
        boolean pravilan = false;


        while (!pravilan && indeksSin > 0) {

            if (roditelj.compareTo(sin) > 0) {
                pravilan = true;
            } else {

                swap(indeksSin, indeksRod);
                indeksSin = indeksRod;
                indeksRod = (indeksRod - 1) / 2;

                roditelj = prioretna.get(indeksRod);
                sin = prioretna.get(indeksSin);
            }
        }
    }

    private void swap(int indeks1, int indeks2) {

        Integer pom = prioretna.get(indeks1);
        prioretna.set(indeks1, prioretna.get(indeks2));
        prioretna.set(indeks2, pom);

    }


}
