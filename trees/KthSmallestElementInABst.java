/*
LeetCode 230. Kth Smallest Element in a BST

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
*/

import java.util.Queue;
import java.util.LinkedList;

public class KthSmallestElementInABst {
    private int count = 0, result = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
    private void inorder(TreeNode node, int k) {
        if (node == null) return;
        inorder(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        inorder(node.right, k);
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
        KthSmallestElementInABst solution = new KthSmallestElementInABst();
        
        // Test case 1: Basic case
        System.out.println("Test case 1:");
        Integer[] arr1 = {3, 1, 4, null, 2};
        TreeNode root1 = solution.createTree(arr1, 0);
        System.out.print("Tree: ");
        solution.printTree(root1);
        System.out.println("1st smallest element: " + solution.kthSmallest(root1, 1)); // Expected: 1
        
        // Test case 2: Larger tree
        System.out.println("\nTest case 2:");
        Integer[] arr2 = {5, 3, 6, 2, 4, null, null, 1};
        TreeNode root2 = solution.createTree(arr2, 0);
        System.out.print("Tree: ");
        solution.printTree(root2);
        System.out.println("3rd smallest element: " + solution.kthSmallest(root2, 3)); // Expected: 3
        
        // Test case 3: Single node
        System.out.println("\nTest case 3:");
        Integer[] arr3 = {1};
        TreeNode root3 = solution.createTree(arr3, 0);
        System.out.print("Tree: ");
        solution.printTree(root3);
        System.out.println("1st smallest element: " + solution.kthSmallest(root3, 1)); // Expected: 1
        
        // Test case 4: Left-skewed tree
        System.out.println("\nTest case 4:");
        Integer[] arr4 = {3, 2, null, 1};
        TreeNode root4 = solution.createTree(arr4, 0);
        System.out.print("Tree: ");
        solution.printTree(root4);
        System.out.println("2nd smallest element: " + solution.kthSmallest(root4, 2)); // Expected: 2
        
        // Test case 5: Right-skewed tree
        System.out.println("\nTest case 5:");
        Integer[] arr5 = {1, null, 2, null, null, null, 3};
        TreeNode root5 = solution.createTree(arr5, 0);
        System.out.print("Tree: ");
        solution.printTree(root5);
        System.out.println("3rd smallest element: " + solution.kthSmallest(root5, 3)); // Expected: 3
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

/*
Explanation:
We use in-order traversal to visit nodes in ascending order. When the count reaches k, we record the value.
*/ 