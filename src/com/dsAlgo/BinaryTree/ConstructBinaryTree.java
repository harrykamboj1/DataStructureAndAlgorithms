package com.dsAlgo.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        System.out.println(buildTree(preorder,inorder));

        // For PostOrder and Inorder
        int[] postOrder = {9,15,7,20,3};
        System.out.println(buildPostTree(postOrder,inorder));
    }

    /*From postOrder Array we confirmed the root i.e. at last index of array and then searched for its index in inorder array
                   rootIndex = 1 (inorder Array)
     Left of this will be nodes of leftSubTree from (inStart to rootIndex-1). And we can count the number of nodes in leftSubTree (rootIndex-inStart-1)

     Now right of this root index will be nodes of right subtree. So for inorder array (rootIndex+1 to inEnd) will make right Subtree;

     Now for PostOrder Array we know firstly we will have left Subtree Nodes and also no. of left subtree nodes are (rootIndex-inStart-1) so that we can count
     them in postOrder Array that is from (posStart to posStart+roodIndex-instart-1)

     Now for right subtree nodes fot post Array  (posStart + rootIndex-inStart to posEnd-1)
    * */
    private static TreeNode buildPostTree(int[] postOrder, int[] inorder) {
        return buildPost(inorder,0,inorder.length-1,postOrder,0,postOrder.length-1);
    }

    private static TreeNode buildPost(int[] inorder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
         if(inStart>inEnd || postStart>postEnd) return null;

         TreeNode root = new TreeNode(postOrder[postEnd]);

         int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root.val){
                rootIndex = i;
                break;
            }
        }

        root.left = buildPost(inorder,inStart,rootIndex-1,postOrder,postStart,postStart+rootIndex-inStart-1);
        root.right = buildPost(inorder,rootIndex+1,inEnd,postOrder,postStart+rootIndex-inStart,postEnd-1);
        return root;
    }


    // For preOrder And Inorder
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode node = build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return node;
    }

    private static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {

        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = build(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map);
        root.right = build(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);


        return root;
    }
}
