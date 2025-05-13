/*
LeetCode 347. Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]
*/

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) count.put(n, count.getOrDefault(n, 0) + 1);
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) res[i] = heap.poll();
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        
        // Test case 1: Multiple elements with different frequencies
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] result1 = solution.topKFrequent(nums1, k1);
        System.out.println("Test case 1: " + Arrays.toString(result1)); // Expected: [1, 2]
        
        // Test case 2: Single element
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = solution.topKFrequent(nums2, k2);
        System.out.println("Test case 2: " + Arrays.toString(result2)); // Expected: [1]
        
        // Test case 3: All elements have same frequency
        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = 3;
        int[] result3 = solution.topKFrequent(nums3, k3);
        System.out.println("Test case 3: " + Arrays.toString(result3)); // Expected: [1, 2, 3] (order may vary)
        
        // Test case 4: Negative numbers
        int[] nums4 = {-1, -1, 2, 2, 2, 3};
        int k4 = 2;
        int[] result4 = solution.topKFrequent(nums4, k4);
        System.out.println("Test case 4: " + Arrays.toString(result4)); // Expected: [2, -1]
    }
}

/*
Explanation:
We use a HashMap to count the frequency of each element. Then, we use a min-heap (priority queue) to keep the top k frequent elements. If the heap exceeds size k, we remove the smallest frequency element. Finally, we extract the elements from the heap.
*/ 