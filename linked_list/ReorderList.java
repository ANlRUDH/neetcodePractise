/*
LeetCode 143. Reorder List

You are given the head of a singly linked list. Reorder the list to be: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You may not modify the values in the list's nodes, only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
*/

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // Find the middle
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse second half
        ListNode prev = null, curr = slow.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        slow.next = null;
        // Merge two halves
        ListNode first = head, second = prev;
        while (second != null) {
            ListNode tmp1 = first.next, tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
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
        ReorderList solution = new ReorderList();
        
        // Test case 1: Even length list
        System.out.println("Test case 1:");
        int[] arr1 = {1, 2, 3, 4};
        ListNode head1 = solution.createList(arr1);
        System.out.print("Original list: ");
        solution.printList(head1);
        solution.reorderList(head1);
        System.out.print("Reordered list: ");
        solution.printList(head1); // Expected: [1,4,2,3]
        
        // Test case 2: Odd length list
        System.out.println("\nTest case 2:");
        int[] arr2 = {1, 2, 3, 4, 5};
        ListNode head2 = solution.createList(arr2);
        System.out.print("Original list: ");
        solution.printList(head2);
        solution.reorderList(head2);
        System.out.print("Reordered list: ");
        solution.printList(head2); // Expected: [1,5,2,4,3]
        
        // Test case 3: Single node
        System.out.println("\nTest case 3:");
        int[] arr3 = {1};
        ListNode head3 = solution.createList(arr3);
        System.out.print("Original list: ");
        solution.printList(head3);
        solution.reorderList(head3);
        System.out.print("Reordered list: ");
        solution.printList(head3); // Expected: [1]
        
        // Test case 4: Two nodes
        System.out.println("\nTest case 4:");
        int[] arr4 = {1, 2};
        ListNode head4 = solution.createList(arr4);
        System.out.print("Original list: ");
        solution.printList(head4);
        solution.reorderList(head4);
        System.out.print("Reordered list: ");
        solution.printList(head4); // Expected: [1,2]
        
        // Test case 5: Longer list
        System.out.println("\nTest case 5:");
        int[] arr5 = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head5 = solution.createList(arr5);
        System.out.print("Original list: ");
        solution.printList(head5);
        solution.reorderList(head5);
        System.out.print("Reordered list: ");
        solution.printList(head5); // Expected: [1,8,2,7,3,6,4,5]
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

/*
Explanation:
Find the middle of the list, reverse the second half, and merge the two halves by alternating nodes.
*/ 