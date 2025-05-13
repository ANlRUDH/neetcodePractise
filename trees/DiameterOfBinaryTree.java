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
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
        
        // Test case 1: Example from problem
        System.out.println("Test case 1:");
        Integer[] arr1 = {1, 2, 3, 4, 5};
        TreeNode root1 = solution.createTree(arr1, 0);
        System.out.print("Tree: ");
        solution.printTree(root1);
        System.out.println("Diameter: " + solution.diameterOfBinaryTree(root1)); // Expected: 3
        
        // Test case 2: Example from problem
        System.out.println("\nTest case 2:");
        Integer[] arr2 = {1, 2};
        TreeNode root2 = solution.createTree(arr2, 0);
        System.out.print("Tree: ");
        solution.printTree(root2);
        System.out.println("Diameter: " + solution.diameterOfBinaryTree(root2)); // Expected: 1
        
        // Test case 3: Empty tree
        System.out.println("\nTest case 3:");
        Integer[] arr3 = {};
        TreeNode root3 = solution.createTree(arr3, 0);
        System.out.print("Tree: ");
        solution.printTree(root3);
        System.out.println("Diameter: " + solution.diameterOfBinaryTree(root3)); // Expected: 0
        
        // Test case 4: Single node
        System.out.println("\nTest case 4:");
        Integer[] arr4 = {1};
        TreeNode root4 = solution.createTree(arr4, 0);
        System.out.print("Tree: ");
        solution.printTree(root4);
        System.out.println("Diameter: " + solution.diameterOfBinaryTree(root4)); // Expected: 0
        
        // Test case 5: Complex tree
        System.out.println("\nTest case 5:");
        Integer[] arr5 = {1, 2, 3, 4, 5, null, null, 6, 7, 8, 9};
        TreeNode root5 = solution.createTree(arr5, 0);
        System.out.print("Tree: ");
        solution.printTree(root5);
        System.out.println("Diameter: " + solution.diameterOfBinaryTree(root5)); // Expected: 5
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