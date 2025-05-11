/*
LeetCode 105. Construct Binary Tree from Preorder and Inorder Traversal

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
*/

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private HashMap<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inorderMap.put(inorder[i], i);
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    private TreeNode build(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inorderMap.get(root.val);
        int leftSize = inRoot - inStart;
        root.left = build(preorder, preStart + 1, preStart + leftSize, inStart, inRoot - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inRoot + 1, inEnd);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

/*
Explanation:
We use recursion and a HashMap to quickly find the root in inorder. Build left and right subtrees using the indices from preorder and inorder arrays.
*/ 