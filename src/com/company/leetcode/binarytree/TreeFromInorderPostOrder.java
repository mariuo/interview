package com.company.leetcode.binarytree;

public class TreeFromInorderPostOrder {

    int in;
    int post;
    private TreeNode build(int[] inorder, int[] postorder, int boundary) {
        if(in < 0 || inorder[in] == boundary) return null;
        TreeNode x = new TreeNode(postorder[post--]);
        x.right = build(inorder, postorder, x.val);
        in--;
        x.left = build(inorder,postorder,boundary);
        return x;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        this.in = n-1;
        this.post = n-1;
        return build(inorder, postorder, Integer.MIN_VALUE);
    }               

}
