package com.dsAlgo.BST;

import com.dsAlgo.BinaryTree.TreeNode;

public class kthSmallest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(kthSmallestValue(root,3));
    }
    public  static int kthSmallestValue(TreeNode root, int k) {
        TreeNode value =  smallest(root,new int[]{k});
        if(value!=null){
            return value.val;
        }
        return -1;
    }

    public static TreeNode  smallest(TreeNode root,int[] k){
        if(root==null)
            return null;

        TreeNode left=smallest(root.left,k);
        if(left!=null)
            return left;
        k[0]--;
        if(k[0]==0)
            return root;

        return smallest(root.right,k);
    }
}
