/*
LeetCode 100. Same Tree

Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false
*/

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
        SameTree solution = new SameTree();
        
        // Test case 1: Example from problem
        System.out.println("Test case 1:");
        Integer[] p1 = {1, 2, 3};
        Integer[] q1 = {1, 2, 3};
        TreeNode tree1 = solution.createTree(p1, 0);
        TreeNode tree2 = solution.createTree(q1, 0);
        System.out.print("Tree 1: ");
        solution.printTree(tree1);
        System.out.print("Tree 2: ");
        solution.printTree(tree2);
        System.out.println("Are trees same? " + solution.isSameTree(tree1, tree2)); // Expected: true
        
        // Test case 2: Example from problem
        System.out.println("\nTest case 2:");
        Integer[] p2 = {1, 2};
        Integer[] q2 = {1, null, 2};
        TreeNode tree3 = solution.createTree(p2, 0);
        TreeNode tree4 = solution.createTree(q2, 0);
        System.out.print("Tree 1: ");
        solution.printTree(tree3);
        System.out.print("Tree 2: ");
        solution.printTree(tree4);
        System.out.println("Are trees same? " + solution.isSameTree(tree3, tree4)); // Expected: false
        
        // Test case 3: Example from problem
        System.out.println("\nTest case 3:");
        Integer[] p3 = {1, 2, 1};
        Integer[] q3 = {1, 1, 2};
        TreeNode tree5 = solution.createTree(p3, 0);
        TreeNode tree6 = solution.createTree(q3, 0);
        System.out.print("Tree 1: ");
        solution.printTree(tree5);
        System.out.print("Tree 2: ");
        solution.printTree(tree6);
        System.out.println("Are trees same? " + solution.isSameTree(tree5, tree6)); // Expected: false
        
        // Test case 4: Empty trees
        System.out.println("\nTest case 4:");
        Integer[] p4 = {};
        Integer[] q4 = {};
        TreeNode tree7 = solution.createTree(p4, 0);
        TreeNode tree8 = solution.createTree(q4, 0);
        System.out.print("Tree 1: ");
        solution.printTree(tree7);
        System.out.print("Tree 2: ");
        solution.printTree(tree8);
        System.out.println("Are trees same? " + solution.isSameTree(tree7, tree8)); // Expected: true
        
        // Test case 5: Different values
        System.out.println("\nTest case 5:");
        Integer[] p5 = {1, 2, 3};
        Integer[] q5 = {1, 2, 4};
        TreeNode tree9 = solution.createTree(p5, 0);
        TreeNode tree10 = solution.createTree(q5, 0);
        System.out.print("Tree 1: ");
        solution.printTree(tree9);
        System.out.print("Tree 2: ");
        solution.printTree(tree10);
        System.out.println("Are trees same? " + solution.isSameTree(tree9, tree10)); // Expected: false
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

/*
Explanation:
We recursively compare the values and structure of both trees. If all nodes match, the trees are the same.
*/ 