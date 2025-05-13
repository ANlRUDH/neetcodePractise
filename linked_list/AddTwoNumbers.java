/*
LeetCode 2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
*/

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
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
        AddTwoNumbers solution = new AddTwoNumbers();
        
        // Test case 1: Basic case
        System.out.println("Test case 1:");
        int[] arr1 = {2, 4, 3};
        int[] arr2 = {5, 6, 4};
        ListNode l1 = solution.createList(arr1);
        ListNode l2 = solution.createList(arr2);
        System.out.print("List 1: ");
        solution.printList(l1);
        System.out.print("List 2: ");
        solution.printList(l2);
        ListNode sum1 = solution.addTwoNumbers(l1, l2);
        System.out.print("Sum: ");
        solution.printList(sum1); // Expected: [7,0,8]
        
        // Test case 2: Single digits
        System.out.println("\nTest case 2:");
        int[] arr3 = {0};
        int[] arr4 = {0};
        ListNode l3 = solution.createList(arr3);
        ListNode l4 = solution.createList(arr4);
        System.out.print("List 1: ");
        solution.printList(l3);
        System.out.print("List 2: ");
        solution.printList(l4);
        ListNode sum2 = solution.addTwoNumbers(l3, l4);
        System.out.print("Sum: ");
        solution.printList(sum2); // Expected: [0]
        
        // Test case 3: Different lengths with carry
        System.out.println("\nTest case 3:");
        int[] arr5 = {9, 9, 9, 9, 9, 9, 9};
        int[] arr6 = {9, 9, 9, 9};
        ListNode l5 = solution.createList(arr5);
        ListNode l6 = solution.createList(arr6);
        System.out.print("List 1: ");
        solution.printList(l5);
        System.out.print("List 2: ");
        solution.printList(l6);
        ListNode sum3 = solution.addTwoNumbers(l5, l6);
        System.out.print("Sum: ");
        solution.printList(sum3); // Expected: [8,9,9,9,0,0,0,1]
        
        // Test case 4: One empty list
        System.out.println("\nTest case 4:");
        int[] arr7 = {1, 2, 3};
        int[] arr8 = {};
        ListNode l7 = solution.createList(arr7);
        ListNode l8 = solution.createList(arr8);
        System.out.print("List 1: ");
        solution.printList(l7);
        System.out.print("List 2: ");
        solution.printList(l8);
        ListNode sum4 = solution.addTwoNumbers(l7, l8);
        System.out.print("Sum: ");
        solution.printList(sum4); // Expected: [1,2,3]
        
        // Test case 5: Large numbers
        System.out.println("\nTest case 5:");
        int[] arr9 = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int[] arr10 = {9, 9, 9, 9};
        ListNode l9 = solution.createList(arr9);
        ListNode l10 = solution.createList(arr10);
        System.out.print("List 1: ");
        solution.printList(l9);
        System.out.print("List 2: ");
        solution.printList(l10);
        ListNode sum5 = solution.addTwoNumbers(l9, l10);
        System.out.print("Sum: ");
        solution.printList(sum5); // Expected: [8,9,9,9,0,0,0,0,0,0,1]
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

/*
Explanation:
We use a dummy node and iterate through both lists, adding corresponding digits and carry. Create new nodes for the result and handle carry at the end.
*/ 