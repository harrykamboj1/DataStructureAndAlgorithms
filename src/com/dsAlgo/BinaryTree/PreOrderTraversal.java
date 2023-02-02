package com.dsAlgo.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(preorderTraversal(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
         list.add(root.val);

         list.addAll(preorderTraversal(root.left));
         list.addAll(preorderTraversal(root.right));


        return list;
    }


}
