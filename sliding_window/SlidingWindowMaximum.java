/*
LeetCode 239. Sliding Window Maximum

You are given an array of integers nums, and there is a sliding window of size k which moves from the very left of the array to the very right. You can only see the k numbers in the window. Each time the window moves right by one position. Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]

Example 2:
Input: nums = [1], k = 1
Output: [1]
*/

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.offerLast(i);
            if (i >= k - 1) res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }

    // Helper method to print an array
    private void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        
        // Test case 1: Basic case
        System.out.println("Test case 1:");
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.print("Input: nums = ");
        solution.printArray(nums1);
        System.out.println("k = " + k1);
        int[] result1 = solution.maxSlidingWindow(nums1, k1);
        System.out.print("Output: ");
        solution.printArray(result1); // Expected: [3,3,5,5,6,7]
        
        // Test case 2: Single element
        System.out.println("\nTest case 2:");
        int[] nums2 = {1};
        int k2 = 1;
        System.out.print("Input: nums = ");
        solution.printArray(nums2);
        System.out.println("k = " + k2);
        int[] result2 = solution.maxSlidingWindow(nums2, k2);
        System.out.print("Output: ");
        solution.printArray(result2); // Expected: [1]
        
        // Test case 3: All negative numbers
        System.out.println("\nTest case 3:");
        int[] nums3 = {-1, -2, -3, -4, -5};
        int k3 = 2;
        System.out.print("Input: nums = ");
        solution.printArray(nums3);
        System.out.println("k = " + k3);
        int[] result3 = solution.maxSlidingWindow(nums3, k3);
        System.out.print("Output: ");
        solution.printArray(result3); // Expected: [-1,-2,-3,-4]
        
        // Test case 4: k equals array length
        System.out.println("\nTest case 4:");
        int[] nums4 = {1, 2, 3, 4, 5};
        int k4 = 5;
        System.out.print("Input: nums = ");
        solution.printArray(nums4);
        System.out.println("k = " + k4);
        int[] result4 = solution.maxSlidingWindow(nums4, k4);
        System.out.print("Output: ");
        solution.printArray(result4); // Expected: [5]
        
        // Test case 5: Alternating numbers
        System.out.println("\nTest case 5:");
        int[] nums5 = {1, -1, 1, -1, 1, -1};
        int k5 = 3;
        System.out.print("Input: nums = ");
        solution.printArray(nums5);
        System.out.println("k = " + k5);
        int[] result5 = solution.maxSlidingWindow(nums5, k5);
        System.out.print("Output: ");
        solution.printArray(result5); // Expected: [1,1,1,1]
    }
}

/*
Explanation:
We use a deque to keep indices of useful elements for the current window. Remove indices out of the window and those whose values are less than the current value. The front of the deque is the max for the window.
*/ 