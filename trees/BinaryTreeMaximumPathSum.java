/*
LeetCode 124. Binary Tree Maximum Path Sum

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. The path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path.
Return the maximum path sum of any non-empty path.

Example 1:
Input: root = [1,2,3]
Output: 6

Example 2:
Input: root = [-10,9,20,null,null,15,7]
Output: 42
*/

public class BinaryTreeMaximumPathSum {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    private int maxGain(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(maxGain(node.left), 0);
        int right = Math.max(maxGain(node.right), 0);
        int priceNewPath = node.val + left + right;
        maxSum = Math.max(maxSum, priceNewPath);
        return node.val + Math.max(left, right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

/*
Explanation:
We use DFS. For each node, calculate the maximum gain from left and right. The answer is the maximum sum of node + left + right for any node.
*/ 