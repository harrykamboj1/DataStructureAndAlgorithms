package com.dsAlgo.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> outer = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSum = queue.size();
            List<Integer> inner = new ArrayList<>();
            for (int i = 0; i < levelSum; i++) {
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                inner.add(queue.poll().val);
            }
            outer.add(inner);
        }
        return outer;
    }
}
