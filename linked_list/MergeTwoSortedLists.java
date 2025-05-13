/*
LeetCode 21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2. Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
*/

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) curr.next = list1;
        if (list2 != null) curr.next = list2;
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
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        
        // Test case 1: Basic case
        System.out.println("Test case 1:");
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        ListNode list1 = solution.createList(arr1);
        ListNode list2 = solution.createList(arr2);
        System.out.print("List 1: ");
        solution.printList(list1);
        System.out.print("List 2: ");
        solution.printList(list2);
        ListNode merged1 = solution.mergeTwoLists(list1, list2);
        System.out.print("Merged list: ");
        solution.printList(merged1); // Expected: [1,1,2,3,4,4]
        
        // Test case 2: Empty lists
        System.out.println("\nTest case 2:");
        int[] arr3 = {};
        int[] arr4 = {};
        ListNode list3 = solution.createList(arr3);
        ListNode list4 = solution.createList(arr4);
        System.out.print("List 1: ");
        solution.printList(list3);
        System.out.print("List 2: ");
        solution.printList(list4);
        ListNode merged2 = solution.mergeTwoLists(list3, list4);
        System.out.print("Merged list: ");
        solution.printList(merged2); // Expected: []
        
        // Test case 3: One empty list
        System.out.println("\nTest case 3:");
        int[] arr5 = {};
        int[] arr6 = {0};
        ListNode list5 = solution.createList(arr5);
        ListNode list6 = solution.createList(arr6);
        System.out.print("List 1: ");
        solution.printList(list5);
        System.out.print("List 2: ");
        solution.printList(list6);
        ListNode merged3 = solution.mergeTwoLists(list5, list6);
        System.out.print("Merged list: ");
        solution.printList(merged3); // Expected: [0]
        
        // Test case 4: Different lengths
        System.out.println("\nTest case 4:");
        int[] arr7 = {1, 3, 5, 7};
        int[] arr8 = {2, 4, 6};
        ListNode list7 = solution.createList(arr7);
        ListNode list8 = solution.createList(arr8);
        System.out.print("List 1: ");
        solution.printList(list7);
        System.out.print("List 2: ");
        solution.printList(list8);
        ListNode merged4 = solution.mergeTwoLists(list7, list8);
        System.out.print("Merged list: ");
        solution.printList(merged4); // Expected: [1,2,3,4,5,6,7]
        
        // Test case 5: Negative numbers
        System.out.println("\nTest case 5:");
        int[] arr9 = {-3, -1, 1};
        int[] arr10 = {-2, 0, 2};
        ListNode list9 = solution.createList(arr9);
        ListNode list10 = solution.createList(arr10);
        System.out.print("List 1: ");
        solution.printList(list9);
        System.out.print("List 2: ");
        solution.printList(list10);
        ListNode merged5 = solution.mergeTwoLists(list9, list10);
        System.out.print("Merged list: ");
        solution.printList(merged5); // Expected: [-3,-2,-1,0,1,2]
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

/*
Explanation:
We use a dummy node to simplify the merge process. Compare the heads of both lists and append the smaller one to the result. Continue until one list is exhausted, then append the rest.
*/ 