package com.company.binaryTree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(10);
        tree.add(8);
        tree.add(5);
        tree.add(9);
        tree.add(7);
        tree.add(18);
        tree.add(13);
        tree.add(20);

        System.out.println("--sorted");
        tree.treeSorted(tree.root);

//        System.out.println("--preSorted");
//        tree.treePreSorted(tree.root);
//
//        System.out.println("--posSorted");
//        tree.treePosSorted(tree.root);

        tree.delete(20);
        System.out.println("--sorted");
        tree.treeSorted(tree.root);

        tree.delete(5);
        System.out.println("--sorted");
        tree.treeSorted(tree.root);

        tree.delete(8);
        System.out.println("--sorted");
        tree.treeSorted(tree.root);

        tree.delete(9);
        System.out.println("--sorted");
        tree.treeSorted(tree.root);

        tree.delete(13);
        System.out.println("--sorted");
        tree.treeSorted(tree.root);

        tree.delete(10);
        System.out.println("--sorted");
        tree.treeSorted(tree.root);


    }

}
