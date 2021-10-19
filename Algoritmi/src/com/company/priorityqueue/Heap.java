package com.company.priorityqueue;

import java.util.ArrayList;

public class Heap {
    private final static int DEFAULT = 100;

    private final ArrayList<Integer> priority;

    public Heap(int len) {
        this.priority = new ArrayList<>(len);
    }

    public Heap() {
        this(DEFAULT);
    }

    public String toString() {
        return priority.toString();
    }

    public void appendNew(Integer newElem) {
        priority.add(newElem);
        fixOrder(priority.size() - 1);
    }

    private void fixOrder(int indexS) {
        int indexP = (indexS - 1) / 2;

        Integer parent = priority.get(indexP);
        Integer son = priority.get(indexS);
        boolean rightOrder = false;


        while (!rightOrder && indexS > 0) {

            if (parent > son) {
                rightOrder = true;
            } else {

                swap(indexS, indexP);
                indexS = indexP;
                indexP = (indexP - 1) / 2;

                parent = priority.get(indexP);
                son = priority.get(indexS);
            }
        }
    }

    private void swap(int index1, int index2) {

        Integer helper = priority.get(index1);
        priority.set(index1, priority.get(index2));
        priority.set(index2, helper);

    }


}
