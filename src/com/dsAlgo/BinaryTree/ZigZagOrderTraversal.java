package com.dsAlgo.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> outer = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) return outer;
        queue.add(root);
        boolean flag = false;
        while (queue.size() > 0) {
            int size = queue.size();
            LinkedList inner = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (flag) {
                    inner.addFirst(node.val);//addFirst method adds the elements at the beginning of the list
                } else {
                    inner.addLast(node.val);//the addLast method adds the elements at the end
                }
                flag = !flag;
                outer.add(inner);
            }
        }

        return outer;
    }
}
