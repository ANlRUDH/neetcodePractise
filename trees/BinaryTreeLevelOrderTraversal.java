/*
LeetCode 102. Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []
*/

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(level);
        }
        return res;
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
        Queue<TreeNode> queue = new LinkedList<>();
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
        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
        
        // Test case 1: Example from problem
        System.out.println("Test case 1:");
        Integer[] arr1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = solution.createTree(arr1, 0);
        System.out.print("Tree: ");
        solution.printTree(root1);
        System.out.println("Level order traversal: " + solution.levelOrder(root1)); // Expected: [[3],[9,20],[15,7]]
        
        // Test case 2: Single node
        System.out.println("\nTest case 2:");
        Integer[] arr2 = {1};
        TreeNode root2 = solution.createTree(arr2, 0);
        System.out.print("Tree: ");
        solution.printTree(root2);
        System.out.println("Level order traversal: " + solution.levelOrder(root2)); // Expected: [[1]]
        
        // Test case 3: Empty tree
        System.out.println("\nTest case 3:");
        TreeNode root3 = null;
        System.out.print("Tree: ");
        solution.printTree(root3);
        System.out.println("Level order traversal: " + solution.levelOrder(root3)); // Expected: []
        
        // Test case 4: Left-skewed tree
        System.out.println("\nTest case 4:");
        Integer[] arr4 = {1, 2, null, 3};
        TreeNode root4 = solution.createTree(arr4, 0);
        System.out.print("Tree: ");
        solution.printTree(root4);
        System.out.println("Level order traversal: " + solution.levelOrder(root4)); // Expected: [[1],[2],[3]]
        
        // Test case 5: Right-skewed tree
        System.out.println("\nTest case 5:");
        Integer[] arr5 = {1, null, 2, null, null, null, 3};
        TreeNode root5 = solution.createTree(arr5, 0);
        System.out.print("Tree: ");
        solution.printTree(root5);
        System.out.println("Level order traversal: " + solution.levelOrder(root5)); // Expected: [[1],[2],[3]]
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

/*
Explanation:
We use a queue to perform BFS. For each level, process all nodes and add their children to the queue.
*/ 