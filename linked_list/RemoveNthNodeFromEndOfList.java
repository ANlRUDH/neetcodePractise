/*
LeetCode 19. Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]
*/

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        for (int i = 0; i <= n; i++) first = first.next;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
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
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        
        // Test case 1: Remove second node from end
        System.out.println("Test case 1:");
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode head1 = solution.createList(arr1);
        System.out.print("Original list: ");
        solution.printList(head1);
        ListNode result1 = solution.removeNthFromEnd(head1, 2);
        System.out.print("After removing 2nd node from end: ");
        solution.printList(result1); // Expected: [1,2,3,5]
        
        // Test case 2: Remove last node
        System.out.println("\nTest case 2:");
        int[] arr2 = {1, 2};
        ListNode head2 = solution.createList(arr2);
        System.out.print("Original list: ");
        solution.printList(head2);
        ListNode result2 = solution.removeNthFromEnd(head2, 1);
        System.out.print("After removing last node: ");
        solution.printList(result2); // Expected: [1]
        
        // Test case 3: Remove only node
        System.out.println("\nTest case 3:");
        int[] arr3 = {1};
        ListNode head3 = solution.createList(arr3);
        System.out.print("Original list: ");
        solution.printList(head3);
        ListNode result3 = solution.removeNthFromEnd(head3, 1);
        System.out.print("After removing only node: ");
        solution.printList(result3); // Expected: []
        
        // Test case 4: Remove first node
        System.out.println("\nTest case 4:");
        int[] arr4 = {1, 2, 3, 4, 5};
        ListNode head4 = solution.createList(arr4);
        System.out.print("Original list: ");
        solution.printList(head4);
        ListNode result4 = solution.removeNthFromEnd(head4, 5);
        System.out.print("After removing first node: ");
        solution.printList(result4); // Expected: [2,3,4,5]
        
        // Test case 5: Longer list
        System.out.println("\nTest case 5:");
        int[] arr5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode head5 = solution.createList(arr5);
        System.out.print("Original list: ");
        solution.printList(head5);
        ListNode result5 = solution.removeNthFromEnd(head5, 4);
        System.out.print("After removing 4th node from end: ");
        solution.printList(result5); // Expected: [1,2,3,4,5,7,8,9,10]
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

/*
Explanation:
We use two pointers. Move the first pointer n+1 steps ahead, then move both pointers until the first reaches the end. The second pointer will be just before the node to remove.
*/ 