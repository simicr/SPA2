package com.company.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>>{

    protected BinaryTreeNode<T> root;
    public BinaryTreeNode<T> getRoot() { return root; }
    public BinaryTree(){
        this.root = null;
    }

    public BinaryTree(BinaryTreeNode<T> root){
        this.root = root;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean dfsRecursive(T info){
       return dfsRecursive(root, info);
    }
    private boolean dfsRecursive(BinaryTreeNode<T> root, T info){

        if(root == null){
            return false;
        }
        System.out.print(root.getInfo() + " ");
        if(root.getInfo().equals(info)){
            return true;
        }

        boolean foundLeft = dfsRecursive(root.getLeft(), info);
        boolean foundRight = dfsRecursive(root.getRight(), info);

        return foundLeft || foundRight;
    }

    public boolean dfsIterative(T info){
        return dfsIterative(root, info);
    }
    private boolean dfsIterative(BinaryTreeNode<T> root, T info){

        if(isEmpty()){
            return false;
        }

        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            BinaryTreeNode<T> curr = stack.pop();
            System.out.print(curr.getInfo() + " ");
            if( curr.getInfo().equals(info)){
                return true;
            } else {
                BinaryTreeNode<T> left = curr.getLeft();
                BinaryTreeNode<T> right = curr.getRight();

                if(right != null){
                    stack.push(right);
                }

                if(left != null) {
                    stack.push(left);
                }
            }
        }

        return false;
    }

    public boolean bfs(T info){
        return bfs(root,info);
    }
    private boolean bfs(BinaryTreeNode<T> root, T info){
        if(isEmpty()){
            return false;
        }

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryTreeNode<T> curr = queue.remove();
            System.out.print(curr.getInfo() + " ");
            if( curr.getInfo().equals(info)){
                return true;
            } else {
                BinaryTreeNode<T> left = curr.getLeft();
                BinaryTreeNode<T> right = curr.getRight();


                if(left != null) {
                    queue.add(left);
                }

                if(right != null){
                    queue.add(right);
                }
            }
        }

        return false;
    }

    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(BinaryTreeNode<T> root){
        if(root != null ){
            inOrder(root.getLeft());
            System.out.print(root + " ");
            inOrder(root.getRight());
        }
    }

    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(BinaryTreeNode<T> root){
        if (root != null) {
            System.out.print(root + " ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(BinaryTreeNode<T> root){
        if(root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root + " ");
        }

    }
}
