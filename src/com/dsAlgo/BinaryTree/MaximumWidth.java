package com.dsAlgo.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumWidth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(9);
        System.out.println(widthOfBinaryTree(root));
    }
    public static  int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;

        int ans=0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        while (!queue.isEmpty()){
            int size = queue.size();
            int left = queue.peek().index;
            int right = queue.peek().index;
            while (size -->0){
                Pair temp = queue.poll();
                right = temp.index;
                if(temp.root.left!=null) queue.add(new Pair(temp.root.left,temp.index*2+1));
                if(temp.root.right!=null) queue.add(new Pair(temp.root.right,temp.index*2+2));
            }

            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }

    static class Pair{
        TreeNode root;
        int index;

        Pair(TreeNode root,int index){
            this.root=root;
            this.index=index;
        }
    }
}
