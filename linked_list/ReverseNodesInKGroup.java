/*
LeetCode 25. Reverse Nodes in k-Group

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list. k is a positive integer and is less than or equal to the length of the list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
*/

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count-- > 0) {
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

/*
Explanation:
We recursively reverse every k nodes. For each group, reverse the links and connect to the result of the next group. If less than k nodes remain, leave them as is.
*/ 