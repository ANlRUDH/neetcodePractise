/*
LeetCode 206. Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []
*/

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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
        ReverseLinkedList solution = new ReverseLinkedList();
        
        // Test case 1: Basic case
        System.out.println("Test case 1:");
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode head1 = solution.createList(arr1);
        System.out.print("Original list: ");
        solution.printList(head1);
        ListNode reversed1 = solution.reverseList(head1);
        System.out.print("Reversed list: ");
        solution.printList(reversed1); // Expected: [5,4,3,2,1]
        
        // Test case 2: Two nodes
        System.out.println("\nTest case 2:");
        int[] arr2 = {1, 2};
        ListNode head2 = solution.createList(arr2);
        System.out.print("Original list: ");
        solution.printList(head2);
        ListNode reversed2 = solution.reverseList(head2);
        System.out.print("Reversed list: ");
        solution.printList(reversed2); // Expected: [2,1]
        
        // Test case 3: Empty list
        System.out.println("\nTest case 3:");
        int[] arr3 = {};
        ListNode head3 = solution.createList(arr3);
        System.out.print("Original list: ");
        solution.printList(head3);
        ListNode reversed3 = solution.reverseList(head3);
        System.out.print("Reversed list: ");
        solution.printList(reversed3); // Expected: []
        
        // Test case 4: Single node
        System.out.println("\nTest case 4:");
        int[] arr4 = {1};
        ListNode head4 = solution.createList(arr4);
        System.out.print("Original list: ");
        solution.printList(head4);
        ListNode reversed4 = solution.reverseList(head4);
        System.out.print("Reversed list: ");
        solution.printList(reversed4); // Expected: [1]
        
        // Test case 5: Longer list
        System.out.println("\nTest case 5:");
        int[] arr5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode head5 = solution.createList(arr5);
        System.out.print("Original list: ");
        solution.printList(head5);
        ListNode reversed5 = solution.reverseList(head5);
        System.out.print("Reversed list: ");
        solution.printList(reversed5); // Expected: [10,9,8,7,6,5,4,3,2,1]
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

/*
Explanation:
We iterate through the list, reversing the next pointer of each node. We use prev to keep track of the reversed part and curr for the current node.
*/ 