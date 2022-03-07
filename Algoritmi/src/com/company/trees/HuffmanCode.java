package com.company.trees;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class HuffmanCode {

    private class FreqChar implements Comparable<FreqChar>{
        public char sign;
        public int freq;

        public FreqChar(char sign, int freq){
            this.sign = sign;
            this.freq = freq;
        }

        @Override
        public int compareTo(FreqChar that){
            return this.freq - that.freq;
        }

        @Override
        public String toString(){
            return "[" + sign + ", " + freq + "]";
        }
    }

    private BinaryTree<FreqChar> huffmanTree;
    private LinkedList<FreqChar> listOfCharsFreq;
    private HashMap<Character, String> huffmanCode;

    public HuffmanCode(String text) {
        generateFreq(text);
        generateHuffmanTree();
        constructCode();
        String c = code(text);
        System.out.println(c);
    }

    private void generateFreq(String text){
        listOfCharsFreq = new LinkedList<>();
        HashMap<Character, FreqChar> mapOfFreq =
                new HashMap<Character, FreqChar>();

        for(int sign = 0; sign < text.length() ; sign ++){
            char c = text.charAt(sign);
            FreqChar fc = mapOfFreq.get(c);

            if(fc == null){
                fc = new FreqChar(c, 1);
                mapOfFreq.put(c, fc);
                listOfCharsFreq.addLast(fc);
            } else {
                fc.freq++;
            }
        }
    }
    private void generateHuffmanTree(){

        PriorityQueue<BinaryTreeNode<FreqChar>> pq =
                new PriorityQueue<BinaryTreeNode<FreqChar>>(listOfCharsFreq.size());

        Iterator<FreqChar> it = listOfCharsFreq.iterator();
        while(it.hasNext()){
            FreqChar fc = it.next();
            BinaryTreeNode<FreqChar> newNode = new BinaryTreeNode<>(fc);
            pq.add(newNode);
        }

        while(pq.size() >= 2){
            BinaryTreeNode<FreqChar> fc1 = pq.poll();
            BinaryTreeNode<FreqChar> fc2 = pq.poll();
            BinaryTreeNode<FreqChar> newNode = new BinaryTreeNode<>(
                    new FreqChar('?', fc1.getInfo().freq + fc2.getInfo().freq));
            newNode.setLeft(fc1);
            newNode.setRight(fc2);
            pq.add(newNode);
        }

        huffmanTree = new BinaryTree<>(pq.poll());

    }

    private void constructCode(){
        huffmanCode = new HashMap<>();
        constructCode(huffmanTree.getRoot(),"");
    }

    private void constructCode(BinaryTreeNode<FreqChar> root, String s) {

        if(root == null){
            return;
        }
        if(root.getLeft() == null && root.getRight() == null){
            huffmanCode.put(root.getInfo().sign, s);
        }

        constructCode(root.getLeft(), s +"0");
        constructCode(root.getRight(), s + "1");
    }

    private String codeSign(char c){
        return huffmanCode.get(c);
    }
    private String code(String text){
        String res = "";
        for(int i = 0; i < text.length(); i++){
            res += codeSign(text.charAt(i));
        }
        return res;
    }



}
