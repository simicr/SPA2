package com.company.sort;

public class Covek implements Comparable<Covek>{
    String ime;
    int godine;

    Covek(String ime, int godine){
        this.ime = ime;
        this.godine = godine;
    }

    public String toString(){
        return "" + this.godine;
    }
    public String toString(String p){return  this.ime + " " + this.godine;}

    public int compareTo(Covek drugi){
        if(this.godine < drugi.godine)
            return -1;
        if (this.godine == drugi.godine)
            return 0;
        return 1;
    }
}
