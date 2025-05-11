/*
LeetCode 572. Subtree of Another Tree

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
*/

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

/*
Explanation:
For each node in root, check if the subtree starting at that node is the same as subRoot using a helper function.
*/ 