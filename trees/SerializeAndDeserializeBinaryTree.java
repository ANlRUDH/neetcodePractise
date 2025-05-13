/*
LeetCode 297. Serialize and Deserialize Binary Tree

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example 1:
Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]

Example 2:
Input: root = []
Output: []
*/

import java.util.*;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }
    private TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
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
        SerializeAndDeserializeBinaryTree solution = new SerializeAndDeserializeBinaryTree();
        
        // Test case 1: Basic case
        System.out.println("Test case 1:");
        Integer[] arr1 = {1, 2, 3, null, null, 4, 5};
        TreeNode root1 = solution.createTree(arr1, 0);
        System.out.print("Original tree: ");
        solution.printTree(root1);
        String serialized1 = solution.serialize(root1);
        System.out.println("Serialized: " + serialized1);
        TreeNode deserialized1 = solution.deserialize(serialized1);
        System.out.print("Deserialized tree: ");
        solution.printTree(deserialized1);
        
        // Test case 2: Empty tree
        System.out.println("\nTest case 2:");
        Integer[] arr2 = {};
        TreeNode root2 = solution.createTree(arr2, 0);
        System.out.print("Original tree: ");
        solution.printTree(root2);
        String serialized2 = solution.serialize(root2);
        System.out.println("Serialized: " + serialized2);
        TreeNode deserialized2 = solution.deserialize(serialized2);
        System.out.print("Deserialized tree: ");
        solution.printTree(deserialized2);
        
        // Test case 3: Single node
        System.out.println("\nTest case 3:");
        Integer[] arr3 = {1};
        TreeNode root3 = solution.createTree(arr3, 0);
        System.out.print("Original tree: ");
        solution.printTree(root3);
        String serialized3 = solution.serialize(root3);
        System.out.println("Serialized: " + serialized3);
        TreeNode deserialized3 = solution.deserialize(serialized3);
        System.out.print("Deserialized tree: ");
        solution.printTree(deserialized3);
        
        // Test case 4: Left-skewed tree
        System.out.println("\nTest case 4:");
        Integer[] arr4 = {1, 2, null, 3};
        TreeNode root4 = solution.createTree(arr4, 0);
        System.out.print("Original tree: ");
        solution.printTree(root4);
        String serialized4 = solution.serialize(root4);
        System.out.println("Serialized: " + serialized4);
        TreeNode deserialized4 = solution.deserialize(serialized4);
        System.out.print("Deserialized tree: ");
        solution.printTree(deserialized4);
        
        // Test case 5: Right-skewed tree
        System.out.println("\nTest case 5:");
        Integer[] arr5 = {1, null, 2, null, null, null, 3};
        TreeNode root5 = solution.createTree(arr5, 0);
        System.out.print("Original tree: ");
        solution.printTree(root5);
        String serialized5 = solution.serialize(root5);
        System.out.println("Serialized: " + serialized5);
        TreeNode deserialized5 = solution.deserialize(serialized5);
        System.out.print("Deserialized tree: ");
        solution.printTree(deserialized5);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

/*
Explanation:
We use preorder traversal for serialization. For deserialization, we use a queue to reconstruct the tree recursively.
*/ 