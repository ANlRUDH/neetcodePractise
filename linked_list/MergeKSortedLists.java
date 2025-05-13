/*
LeetCode 23. Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order. Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []
*/

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) if (node != null) pq.add(node);
        ListNode dummy = new ListNode(0), curr = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) pq.add(node.next);
        }
        return dummy.next;
    }

    // Helper method to create a linked list from an array
    private ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Helper method to print a linked list
    private void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(",");
            curr = curr.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();
        
        // Test case 1: Basic case with three lists
        System.out.println("Test case 1:");
        int[][] arr1 = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] lists1 = new ListNode[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            lists1[i] = solution.createList(arr1[i]);
            System.out.print("List " + (i + 1) + ": ");
            solution.printList(lists1[i]);
        }
        ListNode result1 = solution.mergeKLists(lists1);
        System.out.print("Merged list: ");
        solution.printList(result1); // Expected: [1,1,2,3,4,4,5,6]
        
        // Test case 2: Empty array of lists
        System.out.println("\nTest case 2:");
        ListNode[] lists2 = new ListNode[0];
        System.out.println("Empty array of lists");
        ListNode result2 = solution.mergeKLists(lists2);
        System.out.print("Merged list: ");
        solution.printList(result2); // Expected: []
        
        // Test case 3: Array with empty list
        System.out.println("\nTest case 3:");
        ListNode[] lists3 = {null};
        System.out.println("Array with empty list");
        ListNode result3 = solution.mergeKLists(lists3);
        System.out.print("Merged list: ");
        solution.printList(result3); // Expected: []
        
        // Test case 4: Two lists with different lengths
        System.out.println("\nTest case 4:");
        int[][] arr4 = {{1, 3, 5, 7}, {2, 4, 6}};
        ListNode[] lists4 = new ListNode[arr4.length];
        for (int i = 0; i < arr4.length; i++) {
            lists4[i] = solution.createList(arr4[i]);
            System.out.print("List " + (i + 1) + ": ");
            solution.printList(lists4[i]);
        }
        ListNode result4 = solution.mergeKLists(lists4);
        System.out.print("Merged list: ");
        solution.printList(result4); // Expected: [1,2,3,4,5,6,7]
        
        // Test case 5: Multiple lists with negative numbers
        System.out.println("\nTest case 5:");
        int[][] arr5 = {{-3, -1, 1}, {-2, 0, 2}, {-4, 4}};
        ListNode[] lists5 = new ListNode[arr5.length];
        for (int i = 0; i < arr5.length; i++) {
            lists5[i] = solution.createList(arr5[i]);
            System.out.print("List " + (i + 1) + ": ");
            solution.printList(lists5[i]);
        }
        ListNode result5 = solution.mergeKLists(lists5);
        System.out.print("Merged list: ");
        solution.printList(result5); // Expected: [-4,-3,-2,-1,0,1,2,4]
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

/*
Explanation:
We use a min-heap (priority queue) to always get the smallest node among the k lists. Add the next node from the list after polling.
*/ 