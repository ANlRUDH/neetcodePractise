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
        BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();
        
        // Test case 1: Basic case
        System.out.println("Test case 1:");
        Integer[] arr1 = {1, 2, 3};
        TreeNode root1 = solution.createTree(arr1, 0);
        System.out.print("Tree: ");
        solution.printTree(root1);
        System.out.println("Maximum path sum: " + solution.maxPathSum(root1)); // Expected: 6
        
        // Test case 2: Negative values
        System.out.println("\nTest case 2:");
        Integer[] arr2 = {-10, 9, 20, null, null, 15, 7};
        TreeNode root2 = solution.createTree(arr2, 0);
        System.out.print("Tree: ");
        solution.printTree(root2);
        System.out.println("Maximum path sum: " + solution.maxPathSum(root2)); // Expected: 42
        
        // Test case 3: Single node
        System.out.println("\nTest case 3:");
        Integer[] arr3 = {1};
        TreeNode root3 = solution.createTree(arr3, 0);
        System.out.print("Tree: ");
        solution.printTree(root3);
        System.out.println("Maximum path sum: " + solution.maxPathSum(root3)); // Expected: 1
        
        // Test case 4: All negative values
        System.out.println("\nTest case 4:");
        Integer[] arr4 = {-1, -2, -3};
        TreeNode root4 = solution.createTree(arr4, 0);
        System.out.print("Tree: ");
        solution.printTree(root4);
        System.out.println("Maximum path sum: " + solution.maxPathSum(root4)); // Expected: -1
        
        // Test case 5: Complex tree
        System.out.println("\nTest case 5:");
        Integer[] arr5 = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        TreeNode root5 = solution.createTree(arr5, 0);
        System.out.print("Tree: ");
        solution.printTree(root5);
        System.out.println("Maximum path sum: " + solution.maxPathSum(root5)); // Expected: 48
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