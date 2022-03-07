package com.company.trees;

public class BinaryTreeNode <T extends Comparable<T>> implements Comparable<BinaryTreeNode<T>>{

    private T info;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T info){
        this.info = info;
        this.left = null;
        this.right = null;
    }

    public T getInfo(){
        return this.info;
    }
    public BinaryTreeNode<T> getLeft() {
        return left;
    }
    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setInfo(T info) {
        this.info = info;
    }
    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }
    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    @Override
    public int compareTo(BinaryTreeNode<T> that){

        return this.info.compareTo(that.info);
    }
    @Override
    public String toString(){
        return info.toString();
    }
}
