package com.dsAlgo.BinaryTree;

public class LCA {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right = new TreeNode(2);
        root.left.left = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
TreeNode val = lowestCommonAncestor(root,root.left,root.left.right.right);
        System.out.println(val.val);

    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Integer pCount = 0;
        Integer qCount = 0;
      return lca(root,p,q,pCount,qCount);
    }

    private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q, Integer pCount, Integer qCount) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q, pCount, qCount);
        TreeNode right = lca(root.right, p, q, pCount, qCount);

        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else{
            return root;
        }
    }
}
