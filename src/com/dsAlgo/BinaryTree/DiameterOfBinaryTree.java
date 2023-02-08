package com.dsAlgo.BinaryTree;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(diameterOfBinaryTree(root));
    }
    public static int diameterOfBinaryTree(TreeNode root) {
       int[] diameter = new int[1];
       maxDepth(root,diameter);
       return diameter[0];
    }

    private static   int maxDepth(TreeNode root, int[] diameter) {
        if(root==null){
            return 0;
        }

        int lmax = maxDepth(root.left, diameter);
        int rmax =  maxDepth(root.right, diameter);

        diameter[0] = Math.max(diameter[0],lmax+rmax);

        return 1+Math.max(lmax,rmax);
    }

}
