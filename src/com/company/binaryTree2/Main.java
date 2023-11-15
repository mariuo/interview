package com.company.binaryTree2;

public class Main {
    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.insert(10, tree.root);
        tree.insert(8, tree.root);
        tree.insert(5, tree.root);
        tree.insert(9, tree.root);
        tree.insert(7, tree.root);
        tree.insert(18, tree.root);
        tree.insert(13, tree.root);
        tree.insert(20, tree.root);

        /**
         *            10
         *         /      \
         *        8       18
         *      /  \     /  \
         *     5    9   13   20
          *      \
         *       7
         */

//        System.out.println("PRE-ORDER");
//        tree.preOrder(tree.root);

        System.out.println("IN-ORDER");
        tree.inOrder(tree.root);
//
//        System.out.println("POS-ORDER");
//        tree.posOrder(tree.root);

        System.out.println("Delete 10");
        tree.delete(10,tree.root);

        System.out.println("IN-ORDER");
        tree.inOrder(tree.root);



    }

}
