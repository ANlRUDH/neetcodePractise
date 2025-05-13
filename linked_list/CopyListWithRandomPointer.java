/*
LeetCode 138. Copy List with Random Pointer

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null. Construct a deep copy of the list.

Example 1:
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Example 3:
Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
*/

import java.util.HashMap;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    // Helper method to create a linked list from arrays of values and random indices
    private Node createList(int[] values, Integer[] randomIndices) {
        if (values == null || values.length == 0) return null;
        Node[] nodes = new Node[values.length];
        // Create all nodes first
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Node(values[i]);
        }
        // Set next pointers
        for (int i = 0; i < values.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        // Set random pointers
        for (int i = 0; i < values.length; i++) {
            if (randomIndices[i] != null) {
                nodes[i].random = nodes[randomIndices[i]];
            }
        }
        return nodes[0];
    }

    // Helper method to print a linked list
    private void printList(Node head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        Node curr = head;
        while (curr != null) {
            System.out.print("[" + curr.val + ",");
            if (curr.random == null) {
                System.out.print("null");
            } else {
                // Find the index of the random node
                Node temp = head;
                int index = 0;
                while (temp != curr.random) {
                    temp = temp.next;
                    index++;
                }
                System.out.print(index);
            }
            System.out.print("]");
            if (curr.next != null) System.out.print(",");
            curr = curr.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();
        
        // Test case 1: Complex list
        System.out.println("Test case 1:");
        int[] values1 = {7, 13, 11, 10, 1};
        Integer[] randomIndices1 = {null, 0, 4, 2, 0};
        Node head1 = solution.createList(values1, randomIndices1);
        System.out.print("Original list: ");
        solution.printList(head1);
        Node copy1 = solution.copyRandomList(head1);
        System.out.print("Copied list: ");
        solution.printList(copy1);
        
        // Test case 2: Two nodes with same random
        System.out.println("\nTest case 2:");
        int[] values2 = {1, 2};
        Integer[] randomIndices2 = {1, 1};
        Node head2 = solution.createList(values2, randomIndices2);
        System.out.print("Original list: ");
        solution.printList(head2);
        Node copy2 = solution.copyRandomList(head2);
        System.out.print("Copied list: ");
        solution.printList(copy2);
        
        // Test case 3: Three nodes with same value
        System.out.println("\nTest case 3:");
        int[] values3 = {3, 3, 3};
        Integer[] randomIndices3 = {null, 0, null};
        Node head3 = solution.createList(values3, randomIndices3);
        System.out.print("Original list: ");
        solution.printList(head3);
        Node copy3 = solution.copyRandomList(head3);
        System.out.print("Copied list: ");
        solution.printList(copy3);
        
        // Test case 4: Single node
        System.out.println("\nTest case 4:");
        int[] values4 = {1};
        Integer[] randomIndices4 = {null};
        Node head4 = solution.createList(values4, randomIndices4);
        System.out.print("Original list: ");
        solution.printList(head4);
        Node copy4 = solution.copyRandomList(head4);
        System.out.print("Copied list: ");
        solution.printList(copy4);
        
        // Test case 5: Empty list
        System.out.println("\nTest case 5:");
        int[] values5 = {};
        Integer[] randomIndices5 = {};
        Node head5 = solution.createList(values5, randomIndices5);
        System.out.print("Original list: ");
        solution.printList(head5);
        Node copy5 = solution.copyRandomList(head5);
        System.out.print("Copied list: ");
        solution.printList(copy5);
    }
}

class Node {
    int val;
    Node next;
    Node random;
    Node(int val) { this.val = val; }
}

/*
Explanation:
We use a HashMap to map original nodes to their copies. First pass: create all nodes. Second pass: set next and random pointers using the map.
*/ 