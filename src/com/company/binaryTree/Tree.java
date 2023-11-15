package com.company.binaryTree;

public class Tree {
    Node root;

    public Tree(){
        this.root = null;
    }
    public Node getRoot() {
        return root;
    }
    void add(int val){
        Node nodeN = new Node(val);
        if (root == null) {
            this.root = nodeN;
        }else{
            Node actual = this.root;
            while(true){
                if(nodeN.getVal() < actual.getVal()){
                    if(actual.getLeft() != null){
                        actual = actual.getLeft();
                    }else{
                        actual.setLeft(nodeN);
                        break;
                    }
                }else{
                    if(actual.getRight() != null){
                        actual = actual.getRight();
                    }else{
                        actual.setRight(nodeN);
                        break;
                    }
                }
            }
        }
    }

    public boolean delete(int val) {
        Node actual = this.root;
        Node parentActual = null;

        while (actual != null) {
            if (actual.getVal() == val) {
                break;
            } else if (val < actual.getVal()) {
                parentActual = actual;
                actual = actual.getLeft();
            } else {
                parentActual = actual;
                actual = actual.getRight();
            }
        }
        if (actual != null) {
            // 2 childs or childs to the rights
            if (actual.getRight() != null) {
                Node sub = actual.getRight();
                Node parentSub = actual;
                while (sub.getLeft() != null) {
                    parentSub = sub;
                    sub = sub.getLeft();
                }
                sub.setLeft(actual.getLeft());
                if (parentActual != null) {
                    if (actual.getVal() < parentActual.getVal()) {
                        parentActual.setLeft(sub);
                    } else {
                        parentActual.setRight(sub);
                    }

                } else {
                    this.root = sub;
                }
                //removed element
                if (sub.getVal() < parentSub.getVal()) {
                    parentSub.setLeft(null);
                } else {
                    parentSub.setRight(null);
                }
            } else if (actual.getLeft() != null) { // only 1 child left
                Node sub = actual.getLeft();
                Node parentSub = actual;
                while (sub.getRight() != null) {
                    parentSub = sub;
                    sub = sub.getRight();
                }

                if (parentActual != null) {
                    if (actual.getVal() < parentActual.getVal()) {
                        parentActual.setLeft(sub);
                    } else {
                        parentActual.setRight(sub);
                    }
                } else {
                    this.root = sub;
                }

                //removed element
                if (sub.getVal() < parentSub.getVal()) {
                    parentSub.setLeft(null);
                } else {
                    parentSub.setRight(null);
                }

            } else { // no child
                if (parentActual != null) {
                    if (actual.getVal() < parentActual.getVal()) {
                        parentActual.setLeft(null);
                    } else {
                        parentActual.setRight(null);
                    }
                } else {
                    this.root = null;
                }
            }
        return true;
        }
        else {
            return false;
        }
    }





    public void treeSorted(Node actual){
        if(actual != null){
            treeSorted(actual.getLeft());
            System.out.println(actual.getVal());
            treeSorted(actual.getRight());
         }
    }
    public void treePreSorted(Node actual){
        if(actual != null){
            System.out.println(actual.getVal());
            treePreSorted(actual.getLeft());
            treePreSorted(actual.getRight());
        }
    }
    public void treePosSorted(Node actual){
        if(actual != null){
            treePosSorted(actual.getLeft());
            treePosSorted(actual.getRight());
            System.out.println(actual.getVal());
        }
    }

}
