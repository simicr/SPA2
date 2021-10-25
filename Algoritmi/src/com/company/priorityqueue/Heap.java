package com.company.priorityqueue;

import java.util.ArrayList;

public class Heap {
    private final static int DEFAULT = 100;

    private final ArrayList<Integer> priority;

    //public methods
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

    public Integer deleteMax() {
        if (isEmpty())
            return null;

        Integer max = maxElem();
        swap(0, priority.size() - 1);
        priority.remove(priority.size() - 1);
        fixOrder();

        return max;
    }
    public boolean isEmpty(){
        return priority.size() == 0;
    }
    public Integer maxElem(){
        return priority.get(0);
    }
    public Integer minElem(){
        int lenght = priority.size();
        int lastParent = (lenght - 2)/2;
        Integer min = priority.get(lastParent+1);
        for(int i = lastParent + 1; i < lenght; i++){
            if(priority.get(i).compareTo(min) < 0){
                min = priority.get(i);
            }
        }
        return min;
    }
    public int size(){
        return priority.size();
    }
    //private methods
    private void fixOrder() {
        if (priority.size() == 0)
            return;
        int formerMin = 0;
        int greaterSon = getGreaterSon(0);
        boolean done = false;

        while (greaterSon != -1 && !done) {
            swap(formerMin, greaterSon);
            formerMin = greaterSon;
            greaterSon = getGreaterSon(formerMin);
            done = priority.get(formerMin).compareTo(priority.get(greaterSon)) > 0;
        }
    }

    private int getGreaterSon(int index) {
        int len = priority.size();
        int target1 = 2*index + 1;
        int target2 = 2*index + 2;

        if(target1 >= len && target2 >= len)
            return -1;
        if(target1 <=len && target2 >= len)
            return target1;

        Integer son1 = priority.get(target1);
        Integer son2 = priority.get(target2);

        if(son1.compareTo(son2) > 0)
            return target1;
        return target2;
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
