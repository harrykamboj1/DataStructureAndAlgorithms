package com.dsAlgo.BinaryTree;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(isBalanced(root));
    }
    public static boolean isBalanced(TreeNode root) {
       return maxDepth(root) != -1;
    }
    public static  int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        int lmax = maxDepth(root.left);
        if(lmax == -1) return -1;
        int rmax =  maxDepth(root.right);
        if(rmax == -1) return -1;

       if(Math.abs(lmax-rmax)>1) return -1;
        return 1+Math.max(lmax,rmax);
    }

}
