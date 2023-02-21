package com.dsAlgo.BST;

import com.dsAlgo.BinaryTree.TreeNode;

public class DeleteNode {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        System.out.println(deleteNode(root,3));
    }
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }

        if(root.val > key)
            root.left = deleteNode(root.left , key);

        else if(root.val < key)
            root.right = deleteNode(root.right , key);

            // node with key , found
        else{
            // case1 - leaf node
            if(root.left == null && root.right == null)
                return null;

            // case2 - 1 child
            if(root.left == null)
                return root.right;

            else if(root.right == null)
                return root.left;

            // case3 - 2 child
            TreeNode next = nextInorderNode(root.right);
            root.val = next.val;
            root.right = deleteNode(root.right , next.val);
        }

        return root;

    }
    static TreeNode nextInorderNode(TreeNode node){
        // find leftmost node

        while(node.left != null)
            node = node.left;

        return node;
    }
}
