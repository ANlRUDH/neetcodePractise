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