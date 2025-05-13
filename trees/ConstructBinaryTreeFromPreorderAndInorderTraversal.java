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
import java.util.Queue;
import java.util.LinkedList;

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

    // Helper method to print tree in level order
    private void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        System.out.print("[");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                System.out.print("null");
            } else {
                System.out.print(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (!queue.isEmpty()) System.out.print(",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        
        // Test case 1: Basic case
        System.out.println("Test case 1:");
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode root1 = solution.buildTree(preorder1, inorder1);
        System.out.print("Constructed tree: ");
        solution.printTree(root1); // Expected: [3,9,20,null,null,15,7]
        
        // Test case 2: Single node
        System.out.println("\nTest case 2:");
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNode root2 = solution.buildTree(preorder2, inorder2);
        System.out.print("Constructed tree: ");
        solution.printTree(root2); // Expected: [-1]
        
        // Test case 3: Left-skewed tree
        System.out.println("\nTest case 3:");
        int[] preorder3 = {1, 2, 3};
        int[] inorder3 = {3, 2, 1};
        TreeNode root3 = solution.buildTree(preorder3, inorder3);
        System.out.print("Constructed tree: ");
        solution.printTree(root3); // Expected: [1,2,null,3]
        
        // Test case 4: Right-skewed tree
        System.out.println("\nTest case 4:");
        int[] preorder4 = {1, 2, 3};
        int[] inorder4 = {1, 2, 3};
        TreeNode root4 = solution.buildTree(preorder4, inorder4);
        System.out.print("Constructed tree: ");
        solution.printTree(root4); // Expected: [1,null,2,null,3]
        
        // Test case 5: Complex tree
        System.out.println("\nTest case 5:");
        int[] preorder5 = {1, 2, 4, 5, 3, 6};
        int[] inorder5 = {4, 2, 5, 1, 6, 3};
        TreeNode root5 = solution.buildTree(preorder5, inorder5);
        System.out.print("Constructed tree: ");
        solution.printTree(root5); // Expected: [1,2,3,4,5,6]
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