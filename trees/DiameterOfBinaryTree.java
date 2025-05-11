/*
LeetCode 543. Diameter of Binary Tree

Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example 1:
Input: root = [1,2,3,4,5]
Output: 3

Example 2:
Input: root = [1,2]
Output: 1
*/

public class DiameterOfBinaryTree {
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }
    private int depth(TreeNode node) {
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

/*
Explanation:
We use DFS to compute the depth of each subtree. The diameter at each node is the sum of the depths of its left and right subtrees. Track the maximum diameter found.
*/ 