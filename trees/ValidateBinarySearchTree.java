/*
LeetCode 98. Validate Binary Search Tree

Given the root of a binary tree, determine if it is a valid binary search tree (BST).
A valid BST is defined as follows:
- The left subtree of a node contains only nodes with keys less than the node's key.
- The right subtree of a node contains only nodes with keys greater than the node's key.
- Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [2,1,3]
Output: true

Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false
*/

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValid(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
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
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        
        // Test case 1: Valid BST
        System.out.println("Test case 1:");
        Integer[] arr1 = {2, 1, 3};
        TreeNode root1 = solution.createTree(arr1, 0);
        System.out.print("Tree: ");
        solution.printTree(root1);
        System.out.println("Is valid BST: " + solution.isValidBST(root1)); // Expected: true
        
        // Test case 2: Invalid BST
        System.out.println("\nTest case 2:");
        Integer[] arr2 = {5, 1, 4, null, null, 3, 6};
        TreeNode root2 = solution.createTree(arr2, 0);
        System.out.print("Tree: ");
        solution.printTree(root2);
        System.out.println("Is valid BST: " + solution.isValidBST(root2)); // Expected: false
        
        // Test case 3: Single node
        System.out.println("\nTest case 3:");
        Integer[] arr3 = {1};
        TreeNode root3 = solution.createTree(arr3, 0);
        System.out.print("Tree: ");
        solution.printTree(root3);
        System.out.println("Is valid BST: " + solution.isValidBST(root3)); // Expected: true
        
        // Test case 4: Empty tree
        System.out.println("\nTest case 4:");
        TreeNode root4 = null;
        System.out.print("Tree: ");
        solution.printTree(root4);
        System.out.println("Is valid BST: " + solution.isValidBST(root4)); // Expected: true
        
        // Test case 5: Invalid BST with equal values
        System.out.println("\nTest case 5:");
        Integer[] arr5 = {2, 2, 2};
        TreeNode root5 = solution.createTree(arr5, 0);
        System.out.print("Tree: ");
        solution.printTree(root5);
        System.out.println("Is valid BST: " + solution.isValidBST(root5)); // Expected: false
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

/*
Explanation:
We use recursion and pass down the valid range for each node. Each node must be within the range (min, max).
*/ 