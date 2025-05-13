/*
LeetCode 572. Subtree of Another Tree

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
*/

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
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
        SubtreeOfAnotherTree solution = new SubtreeOfAnotherTree();
        
        // Test case 1: Example from problem
        System.out.println("Test case 1:");
        Integer[] root1 = {3, 4, 5, 1, 2};
        Integer[] subRoot1 = {4, 1, 2};
        TreeNode tree1 = solution.createTree(root1, 0);
        TreeNode subTree1 = solution.createTree(subRoot1, 0);
        System.out.print("Root tree: ");
        solution.printTree(tree1);
        System.out.print("Subtree: ");
        solution.printTree(subTree1);
        System.out.println("Is subtree? " + solution.isSubtree(tree1, subTree1)); // Expected: true
        
        // Test case 2: Example from problem
        System.out.println("\nTest case 2:");
        Integer[] root2 = {3, 4, 5, 1, 2, null, null, null, null, 0};
        Integer[] subRoot2 = {4, 1, 2};
        TreeNode tree2 = solution.createTree(root2, 0);
        TreeNode subTree2 = solution.createTree(subRoot2, 0);
        System.out.print("Root tree: ");
        solution.printTree(tree2);
        System.out.print("Subtree: ");
        solution.printTree(subTree2);
        System.out.println("Is subtree? " + solution.isSubtree(tree2, subTree2)); // Expected: false
        
        // Test case 3: Empty subtree
        System.out.println("\nTest case 3:");
        Integer[] root3 = {1, 2, 3};
        Integer[] subRoot3 = {};
        TreeNode tree3 = solution.createTree(root3, 0);
        TreeNode subTree3 = solution.createTree(subRoot3, 0);
        System.out.print("Root tree: ");
        solution.printTree(tree3);
        System.out.print("Subtree: ");
        solution.printTree(subTree3);
        System.out.println("Is subtree? " + solution.isSubtree(tree3, subTree3)); // Expected: false
        
        // Test case 4: Same tree
        System.out.println("\nTest case 4:");
        Integer[] root4 = {1, 2, 3};
        Integer[] subRoot4 = {1, 2, 3};
        TreeNode tree4 = solution.createTree(root4, 0);
        TreeNode subTree4 = solution.createTree(subRoot4, 0);
        System.out.print("Root tree: ");
        solution.printTree(tree4);
        System.out.print("Subtree: ");
        solution.printTree(subTree4);
        System.out.println("Is subtree? " + solution.isSubtree(tree4, subTree4)); // Expected: true
        
        // Test case 5: Subtree in left branch
        System.out.println("\nTest case 5:");
        Integer[] root5 = {1, 2, 3, 4, 5};
        Integer[] subRoot5 = {2, 4, 5};
        TreeNode tree5 = solution.createTree(root5, 0);
        TreeNode subTree5 = solution.createTree(subRoot5, 0);
        System.out.print("Root tree: ");
        solution.printTree(tree5);
        System.out.print("Subtree: ");
        solution.printTree(subTree5);
        System.out.println("Is subtree? " + solution.isSubtree(tree5, subTree5)); // Expected: true
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

/*
Explanation:
For each node in root, check if the subtree starting at that node is the same as subRoot using a helper function.
*/ 