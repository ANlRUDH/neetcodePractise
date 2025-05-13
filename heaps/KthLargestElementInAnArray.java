/*
LeetCode 215. Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
*/

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray solution = new KthLargestElementInAnArray();
        
        // Test case 1: Basic case
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Test case 1: " + solution.findKthLargest(nums1, k1)); // Expected: 5
        
        // Test case 2: Duplicate elements
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("Test case 2: " + solution.findKthLargest(nums2, k2)); // Expected: 4
        
        // Test case 3: Single element
        int[] nums3 = {1};
        int k3 = 1;
        System.out.println("Test case 3: " + solution.findKthLargest(nums3, k3)); // Expected: 1
        
        // Test case 4: k equals array length
        int[] nums4 = {1, 2, 3, 4, 5};
        int k4 = 5;
        System.out.println("Test case 4: " + solution.findKthLargest(nums4, k4)); // Expected: 1
        
        // Test case 5: All same elements
        int[] nums5 = {2, 2, 2, 2, 2};
        int k5 = 3;
        System.out.println("Test case 5: " + solution.findKthLargest(nums5, k5)); // Expected: 2
    }
}

/*
Explanation:
We use a min-heap of size k. The root is always the kth largest element. Add new elements and remove the smallest if the heap exceeds size k.
*/ 