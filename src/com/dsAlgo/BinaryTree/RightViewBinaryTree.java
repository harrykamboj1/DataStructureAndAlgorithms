package com.dsAlgo.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RightViewBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        System.out.println(rightSideView(root));
    }
    public static List<Integer> rightSideView(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      rightView(root,result,0);
      return result;
    }
    public static void rightView(TreeNode root,List<Integer> result, Integer level){
        if(root == null){
            return;
        }
        if(level == result.size()){
            result.add(root.val);
        }

        rightView(root.right,result,level);
        rightView(root.left,result,level);
    }
}
