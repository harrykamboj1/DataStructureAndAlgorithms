package com.dsAlgo.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        System.out.println(buildTree(preorder,inorder));

    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        TreeNode node = build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return node;
    }

    private static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {

        if(preStart>preEnd||inStart>inEnd)return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = map.get(root.val);
        int numsLeft = inRoot-inStart;

        root.left = build(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,map);
        root.right = build(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,map);


        return root;
    }
}
