/*
LeetCode 235. Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6

Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
*/

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) root = root.left;
            else if (p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }
        return null;
    }

    // Helper method to create a binary tree from an array
    private TreeNode createTree(Integer[] arr, int i) {
        if (i >= arr.length || arr[i] == null) return null;
        TreeNode root = new TreeNode(arr[i]);
        root.left = createTree(arr, 2 * i + 1);
        root.right = createTree(arr, 2 * i + 2);
        return root;
    }

    // Helper method to print tree in level order
    private void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
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

    // Helper method to find a node by value
    private TreeNode findNode(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (val < root.val) return findNode(root.left, val);
        return findNode(root.right, val);
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfABinarySearchTree solution = new LowestCommonAncestorOfABinarySearchTree();
        
        // Test case 1: Example from problem
        System.out.println("Test case 1:");
        Integer[] arr1 = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root1 = solution.createTree(arr1, 0);
        System.out.print("Tree: ");
        solution.printTree(root1);
        TreeNode p1 = solution.findNode(root1, 2);
        TreeNode q1 = solution.findNode(root1, 8);
        TreeNode lca1 = solution.lowestCommonAncestor(root1, p1, q1);
        System.out.println("LCA of " + p1.val + " and " + q1.val + ": " + lca1.val); // Expected: 6
        
        // Test case 2: Example from problem
        System.out.println("\nTest case 2:");
        TreeNode p2 = solution.findNode(root1, 2);
        TreeNode q2 = solution.findNode(root1, 4);
        TreeNode lca2 = solution.lowestCommonAncestor(root1, p2, q2);
        System.out.println("LCA of " + p2.val + " and " + q2.val + ": " + lca2.val); // Expected: 2
        
        // Test case 3: Same node
        System.out.println("\nTest case 3:");
        TreeNode p3 = solution.findNode(root1, 3);
        TreeNode q3 = solution.findNode(root1, 3);
        TreeNode lca3 = solution.lowestCommonAncestor(root1, p3, q3);
        System.out.println("LCA of " + p3.val + " and " + q3.val + ": " + lca3.val); // Expected: 3
        
        // Test case 4: Root is LCA
        System.out.println("\nTest case 4:");
        TreeNode p4 = solution.findNode(root1, 0);
        TreeNode q4 = solution.findNode(root1, 9);
        TreeNode lca4 = solution.lowestCommonAncestor(root1, p4, q4);
        System.out.println("LCA of " + p4.val + " and " + q4.val + ": " + lca4.val); // Expected: 6
        
        // Test case 5: One node is ancestor of other
        System.out.println("\nTest case 5:");
        TreeNode p5 = solution.findNode(root1, 2);
        TreeNode q5 = solution.findNode(root1, 3);
        TreeNode lca5 = solution.lowestCommonAncestor(root1, p5, q5);
        System.out.println("LCA of " + p5.val + " and " + q5.val + ": " + lca5.val); // Expected: 2
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

/*
Explanation:
We use the properties of BST. If both p and q are less than root, go left. If both are greater, go right. Otherwise, root is the LCA.
*/ 