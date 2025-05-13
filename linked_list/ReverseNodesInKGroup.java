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
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
        
        // Test case 1: Basic case with k=2
        System.out.println("Test case 1:");
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode head1 = solution.createList(arr1);
        System.out.print("Original list: ");
        solution.printList(head1);
        ListNode result1 = solution.reverseKGroup(head1, 2);
        System.out.print("After reversing in groups of 2: ");
        solution.printList(result1); // Expected: [2,1,4,3,5]
        
        // Test case 2: Basic case with k=3
        System.out.println("\nTest case 2:");
        int[] arr2 = {1, 2, 3, 4, 5};
        ListNode head2 = solution.createList(arr2);
        System.out.print("Original list: ");
        solution.printList(head2);
        ListNode result2 = solution.reverseKGroup(head2, 3);
        System.out.print("After reversing in groups of 3: ");
        solution.printList(result2); // Expected: [3,2,1,4,5]
        
        // Test case 3: k equals list length
        System.out.println("\nTest case 3:");
        int[] arr3 = {1, 2, 3, 4};
        ListNode head3 = solution.createList(arr3);
        System.out.print("Original list: ");
        solution.printList(head3);
        ListNode result3 = solution.reverseKGroup(head3, 4);
        System.out.print("After reversing in groups of 4: ");
        solution.printList(result3); // Expected: [4,3,2,1]
        
        // Test case 4: k=1 (no change)
        System.out.println("\nTest case 4:");
        int[] arr4 = {1, 2, 3, 4, 5};
        ListNode head4 = solution.createList(arr4);
        System.out.print("Original list: ");
        solution.printList(head4);
        ListNode result4 = solution.reverseKGroup(head4, 1);
        System.out.print("After reversing in groups of 1: ");
        solution.printList(result4); // Expected: [1,2,3,4,5]
        
        // Test case 5: Empty list
        System.out.println("\nTest case 5:");
        int[] arr5 = {};
        ListNode head5 = solution.createList(arr5);
        System.out.print("Original list: ");
        solution.printList(head5);
        ListNode result5 = solution.reverseKGroup(head5, 2);
        System.out.print("After reversing in groups of 2: ");
        solution.printList(result5); // Expected: []
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