/*
LeetCode 226. Invert Binary Tree

Given the root of a binary tree, invert the tree, and return its root.

Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:
Input: root = [2,1,3]
Output: [2,3,1]

Example 3:
Input: root = []
Output: []
*/

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
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
        InvertBinaryTree solution = new InvertBinaryTree();
        
        // Test case 1: Basic case
        System.out.println("Test case 1:");
        Integer[] arr1 = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root1 = solution.createTree(arr1, 0);
        System.out.print("Original tree: ");
        solution.printTree(root1);
        TreeNode inverted1 = solution.invertTree(root1);
        System.out.print("Inverted tree: ");
        solution.printTree(inverted1);
        
        // Test case 2: Simple tree
        System.out.println("\nTest case 2:");
        Integer[] arr2 = {2, 1, 3};
        TreeNode root2 = solution.createTree(arr2, 0);
        System.out.print("Original tree: ");
        solution.printTree(root2);
        TreeNode inverted2 = solution.invertTree(root2);
        System.out.print("Inverted tree: ");
        solution.printTree(inverted2);
        
        // Test case 3: Empty tree
        System.out.println("\nTest case 3:");
        Integer[] arr3 = {};
        TreeNode root3 = solution.createTree(arr3, 0);
        System.out.print("Original tree: ");
        solution.printTree(root3);
        TreeNode inverted3 = solution.invertTree(root3);
        System.out.print("Inverted tree: ");
        solution.printTree(inverted3);
        
        // Test case 4: Single node
        System.out.println("\nTest case 4:");
        Integer[] arr4 = {1};
        TreeNode root4 = solution.createTree(arr4, 0);
        System.out.print("Original tree: ");
        solution.printTree(root4);
        TreeNode inverted4 = solution.invertTree(root4);
        System.out.print("Inverted tree: ");
        solution.printTree(inverted4);
        
        // Test case 5: Left-skewed tree
        System.out.println("\nTest case 5:");
        Integer[] arr5 = {1, 2, null, 3};
        TreeNode root5 = solution.createTree(arr5, 0);
        System.out.print("Original tree: ");
        solution.printTree(root5);
        TreeNode inverted5 = solution.invertTree(root5);
        System.out.print("Inverted tree: ");
        solution.printTree(inverted5);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

/*
Explanation:
We recursively swap the left and right children of each node in the tree.
*/ 