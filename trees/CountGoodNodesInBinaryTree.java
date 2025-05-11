/*
LeetCode 1448. Count Good Nodes in Binary Tree

Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
Return the number of good nodes in the binary tree.

Example 1:
Input: root = [3,1,4,3,null,1,5]
Output: 4

Example 2:
Input: root = [3,3,null,4,2]
Output: 3

Example 3:
Input: root = [1]
Output: 1
*/

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    private int dfs(TreeNode node, int max) {
        if (node == null) return 0;
        int res = node.val >= max ? 1 : 0;
        max = Math.max(max, node.val);
        res += dfs(node.left, max);
        res += dfs(node.right, max);
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

/*
Explanation:
We use DFS, passing down the maximum value seen so far. If the current node is greater than or equal to max, it's a good node.
*/ 