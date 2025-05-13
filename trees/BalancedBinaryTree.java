/*
LeetCode 110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.
A height-balanced binary tree is a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true
*/

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    private int checkHeight(TreeNode node) {
        if (node == null) return 0;
        int left = checkHeight(node.left);
        if (left == -1) return -1;
        int right = checkHeight(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
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

    public static void main(String[] args) {
        BalancedBinaryTree solution = new BalancedBinaryTree();
        
        // Test case 1: Example from problem
        System.out.println("Test case 1:");
        Integer[] arr1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = solution.createTree(arr1, 0);
        System.out.print("Tree: ");
        solution.printTree(root1);
        System.out.println("Is balanced? " + solution.isBalanced(root1)); // Expected: true
        
        // Test case 2: Example from problem
        System.out.println("\nTest case 2:");
        Integer[] arr2 = {1, 2, 2, 3, 3, null, null, 4, 4};
        TreeNode root2 = solution.createTree(arr2, 0);
        System.out.print("Tree: ");
        solution.printTree(root2);
        System.out.println("Is balanced? " + solution.isBalanced(root2)); // Expected: false
        
        // Test case 3: Empty tree
        System.out.println("\nTest case 3:");
        Integer[] arr3 = {};
        TreeNode root3 = solution.createTree(arr3, 0);
        System.out.print("Tree: ");
        solution.printTree(root3);
        System.out.println("Is balanced? " + solution.isBalanced(root3)); // Expected: true
        
        // Test case 4: Single node
        System.out.println("\nTest case 4:");
        Integer[] arr4 = {1};
        TreeNode root4 = solution.createTree(arr4, 0);
        System.out.print("Tree: ");
        solution.printTree(root4);
        System.out.println("Is balanced? " + solution.isBalanced(root4)); // Expected: true
        
        // Test case 5: Unbalanced tree
        System.out.println("\nTest case 5:");
        Integer[] arr5 = {1, 2, null, 3};
        TreeNode root5 = solution.createTree(arr5, 0);
        System.out.print("Tree: ");
        solution.printTree(root5);
        System.out.println("Is balanced? " + solution.isBalanced(root5)); // Expected: false
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

/*
Explanation:
We use DFS to check the height of each subtree. If the difference is more than 1, return -1 to indicate imbalance. Otherwise, return the height.
*/ 