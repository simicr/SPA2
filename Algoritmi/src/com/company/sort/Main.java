package com.company.sort;

public class Main {
    public static <T> void ispisi(T  [] niz){
        System.out.print(":");
        for(int i = 0; i < niz.length; i++){
                System.out.print(niz[i] + ":");
            }
            System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("Ovo ce biti primeri sortiranja");
        Covek[] ljudi = new Covek[20];
        for(int i = 0; i < ljudi.length; i++){
            int god =(int)(Math.random()*i + 10 + i);
            ljudi[i] = new Covek("Covek" + i,god);
        }
        System.out.println("Pre-sort");
        ispisi(ljudi);
        ShellSort.sort(ljudi);
        System.out.println("Post-sort");
        ispisi(ljudi);

    }
}
