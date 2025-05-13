/*
LeetCode 1448. Count Good Nodes in Binary Tree

Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
Return the number of good nodes in the binary tree.

Example 1:
Input: root = [3,1,4,3,null,1,5]
Output: 4

Example 2:
Input: root = [3,3,null,4,2]
Output: 3

Example 3:
Input: root = [1]
Output: 1
*/

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    private int dfs(TreeNode node, int max) {
        if (node == null) return 0;
        int res = node.val >= max ? 1 : 0;
        max = Math.max(max, node.val);
        res += dfs(node.left, max);
        res += dfs(node.right, max);
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
        CountGoodNodesInBinaryTree solution = new CountGoodNodesInBinaryTree();
        
        // Test case 1: Example from problem
        System.out.println("Test case 1:");
        Integer[] arr1 = {3, 1, 4, 3, null, 1, 5};
        TreeNode root1 = solution.createTree(arr1, 0);
        System.out.print("Tree: ");
        solution.printTree(root1);
        System.out.println("Number of good nodes: " + solution.goodNodes(root1)); // Expected: 4
        
        // Test case 2: Example from problem
        System.out.println("\nTest case 2:");
        Integer[] arr2 = {3, 3, null, 4, 2};
        TreeNode root2 = solution.createTree(arr2, 0);
        System.out.print("Tree: ");
        solution.printTree(root2);
        System.out.println("Number of good nodes: " + solution.goodNodes(root2)); // Expected: 3
        
        // Test case 3: Single node
        System.out.println("\nTest case 3:");
        Integer[] arr3 = {1};
        TreeNode root3 = solution.createTree(arr3, 0);
        System.out.print("Tree: ");
        solution.printTree(root3);
        System.out.println("Number of good nodes: " + solution.goodNodes(root3)); // Expected: 1
        
        // Test case 4: Empty tree
        System.out.println("\nTest case 4:");
        TreeNode root4 = null;
        System.out.print("Tree: ");
        solution.printTree(root4);
        System.out.println("Number of good nodes: " + solution.goodNodes(root4)); // Expected: 0
        
        // Test case 5: All nodes are good
        System.out.println("\nTest case 5:");
        Integer[] arr5 = {5, 4, 3, 2, 1};
        TreeNode root5 = solution.createTree(arr5, 0);
        System.out.print("Tree: ");
        solution.printTree(root5);
        System.out.println("Number of good nodes: " + solution.goodNodes(root5)); // Expected: 5
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

/*
Explanation:
We use DFS, passing down the maximum value seen so far. If the current node is greater than or equal to max, it's a good node.
*/ 