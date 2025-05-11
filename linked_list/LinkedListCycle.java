/*
LeetCode 141. Linked List Cycle

Given head, the head of a linked list, determine if the linked list has a cycle in it.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true

Example 2:
Input: head = [1,2], pos = 0
Output: true

Example 3:
Input: head = [1], pos = -1
Output: false
*/

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

/*
Explanation:
We use two pointers, slow and fast. If there is a cycle, the fast pointer will eventually meet the slow pointer. If fast reaches the end, there is no cycle.
*/ 