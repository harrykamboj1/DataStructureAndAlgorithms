package com.dsAlgo.BST;

import com.dsAlgo.BinaryTree.TreeNode;

public class ValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(isValidBST(root));
    }
    public static boolean isValidBST(TreeNode root) {
         return isValid(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    private static boolean isValid(TreeNode root, long maxValue, long minValue) {
        if(root == null) return true;
        if(root.val>=maxValue || root.val<=minValue)return false;

        return isValid(root.left,root.val,minValue)&& isValid(root.right,maxValue,root.val);
    }
}
