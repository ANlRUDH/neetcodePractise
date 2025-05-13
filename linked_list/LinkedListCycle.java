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

    // Helper method to create a cycle in the linked list
    private void createCycle(ListNode head, int pos) {
        if (pos < 0) return;
        ListNode curr = head;
        ListNode cycleNode = null;
        int index = 0;
        while (curr.next != null) {
            if (index == pos) cycleNode = curr;
            curr = curr.next;
            index++;
        }
        curr.next = cycleNode;
    }

    // Helper method to print a linked list (without cycle)
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
        LinkedListCycle solution = new LinkedListCycle();
        
        // Test case 1: Basic case with cycle
        System.out.println("Test case 1:");
        int[] arr1 = {3, 2, 0, -4};
        ListNode head1 = solution.createList(arr1);
        solution.createCycle(head1, 1);
        System.out.println("List with cycle at pos 1: [3,2,0,-4]");
        System.out.println("Has cycle: " + solution.hasCycle(head1)); // Expected: true
        
        // Test case 2: Two nodes with cycle
        System.out.println("\nTest case 2:");
        int[] arr2 = {1, 2};
        ListNode head2 = solution.createList(arr2);
        solution.createCycle(head2, 0);
        System.out.println("List with cycle at pos 0: [1,2]");
        System.out.println("Has cycle: " + solution.hasCycle(head2)); // Expected: true
        
        // Test case 3: Single node without cycle
        System.out.println("\nTest case 3:");
        int[] arr3 = {1};
        ListNode head3 = solution.createList(arr3);
        System.out.println("List without cycle: [1]");
        System.out.println("Has cycle: " + solution.hasCycle(head3)); // Expected: false
        
        // Test case 4: Empty list
        System.out.println("\nTest case 4:");
        int[] arr4 = {};
        ListNode head4 = solution.createList(arr4);
        System.out.println("Empty list: []");
        System.out.println("Has cycle: " + solution.hasCycle(head4)); // Expected: false
        
        // Test case 5: Longer list with cycle
        System.out.println("\nTest case 5:");
        int[] arr5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode head5 = solution.createList(arr5);
        solution.createCycle(head5, 5);
        System.out.println("List with cycle at pos 5: [1,2,3,4,5,6,7,8,9,10]");
        System.out.println("Has cycle: " + solution.hasCycle(head5)); // Expected: true
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