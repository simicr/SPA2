package com.company.trees;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T>{


        private class SearchResult{
            BinaryTreeNode<T> parent;
            BinaryTreeNode<T> node;

            public SearchResult(BinaryTreeNode<T> n, BinaryTreeNode<T> p){
                parent = p;
                node = n;
            }
        }

        private SearchResult search(T info){

             BinaryTreeNode<T> curr = root;
             BinaryTreeNode<T> par = null;

             boolean found = false;
             while(curr != null && !found){
                 if(curr.getInfo().compareTo(info) == 0){
                     found = true;
                 } else {
                     par = curr;
                     if (info.compareTo(curr.getInfo()) > 0) {
                         curr = curr.getRight();
                     } else {
                         curr = curr.getLeft();
                     }
                 }
             }

            return new SearchResult(curr, par);
        }
        public BinarySearchTree(){
            root = null;
        }
        public boolean isMember(T info){
            SearchResult s = search(info);
            return s.node != null;
        }

        public boolean insert(T info){

            if(root == null){
                root = new BinaryTreeNode<>(info);
                return true;
            }

            SearchResult s = search(info);
            BinaryTreeNode<T> node = s.node;
            BinaryTreeNode<T> parent = s.parent;

            if( node != null){
                return false;
            }

            BinaryTreeNode<T> newNode = new BinaryTreeNode<>(info);
            if(info.compareTo(parent.getInfo()) > 0){
                parent.setRight(newNode);
            } else {
                parent.setLeft(newNode);
            }

            return true;
        }

        public boolean remove(T info){
            SearchResult s = search(info);

            BinaryTreeNode<T> del = s.node;
            BinaryTreeNode<T> parent = s.parent;

            if(del == null){
                return false;
            }

            if(del.getLeft() == null && del.getRight() == null){
                return deleteNoChild(parent,del);
            }

            if (del.getLeft() == null || del.getRight() == null){
                return deleteOneChild(parent,del);
            }

            return deleteTwoChild(parent, del);

        }

        private boolean deleteTwoChild(BinaryTreeNode<T> parent, BinaryTreeNode<T> del){

            SearchResult s = searchLeftest(del.getRight());
            BinaryTreeNode<T> leftyParent = s.parent;
            BinaryTreeNode<T> lefty = s.node;

            if(leftyParent == null){
                del.setRight(lefty.getRight());
            } else {
                leftyParent.setLeft(lefty.getRight());
            }

            del.setInfo(lefty.getInfo());
            return true;
        }
        private SearchResult searchLeftest(BinaryTreeNode<T> root){
            BinaryTreeNode<T> curr = root;
            BinaryTreeNode<T> parent = null;
            while(curr.getLeft() != null){
                parent = curr;
                curr = curr.getLeft();
            }
            return new SearchResult(curr,parent);
        }

        private boolean deleteNoChild(BinaryTreeNode<T> parent, BinaryTreeNode<T> del){

            if(parent == null){
                root = null;
            }

            if(parent.getInfo().compareTo(del.getInfo()) > 0 ){
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
            return true;

        }

        private boolean deleteOneChild(BinaryTreeNode<T> parent, BinaryTreeNode<T> del){
                BinaryTreeNode<T> delChild = del.getLeft();
                if(delChild == null){
                    delChild = del.getRight();
                }

                if(parent == null){
                    root = delChild;
                    return true;
                }

                if(parent.getInfo().compareTo(del.getInfo()) > 0){
                    parent.setLeft(delChild);
                } else {
                    parent.setRight(delChild);
                }
                return true;
        }


}
