package com.company.trees;

public class Main {

    public static void main(String[] args){

        String text = "";
        for(int i = 0; i < 5; i++)
            text+="f";
        for(int i = 0; i < 9; i++)
            text+="e";
        for(int i = 0; i < 12; i++)
            text+="c";
        for(int i = 0; i < 13; i++)
            text+="b";
        for(int i = 0; i < 16; i++)
            text+="d";
        for(int i = 0; i < 45; i++)
            text+="a";

        HuffmanCode h = new HuffmanCode(text);



    }
}
