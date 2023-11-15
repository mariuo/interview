package com.company.binaryTree2;

public class Tree {
    Node root = null;

    public void insert(int info, Node node) {
        if (node == null) {
//            System.out.println(" " + info);
            root = new Node(info);
        } else if (info < node.info) {
            if (node.left == null) {
//                System.out.println(" " + info);
                node.left = new Node(info);
            } else {
                insert(info, node.left);
            }
        } else if (info > node.info) {
            if (node.right == null) {
//                System.out.println(" " + info);
                node.right = new Node(info);
            } else {
                insert(info, node.right);
            }
        }
    }
    // 1. Caso o node nao tem filho = remove ele
    // 2. caso o node possui apenas 1 filho = atualiza o pai com o filho
    // 3. caso o node tem 2 filhos:
    // 3.1 o maior no da esquerda.
    // 3.2 o menor no da direita.
    public Node delete(int info, Node node){
        if(node == null){
            return null;
        }
        if(info < node.info){
            node.left = delete(info, node.left);
        } else if (info > node.info) {
            node.right = delete(info, node.right);
        }else{
            //one child or No children
            if(node.left == null){
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            //two childrens can be the max or min, this is the max of the leftchild.
            node.info = getMax(node.left);
            node.left = delete(node.info, node.left);
        }

        return node;
    }
    public int getMax(Node node){
        if(node.right != null){
            return getMax(node.right);
        }
        return node.info;
    }

    public int getMin(Node node){
        if(node.left != null){
            return getMin(node.left);
        }
        return node.info;
    }

    public void preOrder(Node node) {
        System.out.println(" " + node.info);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    public void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.println(" " + node.info);
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    public void posOrder(Node node) {
        if (node.left != null) {
            posOrder(node.left);
        }
        if (node.right != null) {
            posOrder(node.right);
        }
        System.out.println(" " + node.info);
    }

}
