/*
LeetCode 128. Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
*/

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int streak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    streak++;
                }
                longest = Math.max(longest, streak);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        
        // Test case 1: Basic case with one sequence
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Test case 1: " + solution.longestConsecutive(nums1)); // Expected: 4
        
        // Test case 2: Longer sequence
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Test case 2: " + solution.longestConsecutive(nums2)); // Expected: 9
        
        // Test case 3: Empty array
        int[] nums3 = {};
        System.out.println("Test case 3: " + solution.longestConsecutive(nums3)); // Expected: 0
        
        // Test case 4: Single element
        int[] nums4 = {1};
        System.out.println("Test case 4: " + solution.longestConsecutive(nums4)); // Expected: 1
        
        // Test case 5: Multiple sequences
        int[] nums5 = {1, 2, 3, 5, 6, 7, 9, 10, 11};
        System.out.println("Test case 5: " + solution.longestConsecutive(nums5)); // Expected: 3
    }
}

/*
Explanation:
We use a HashSet to store all numbers. For each number, if it is the start of a sequence (num - 1 not in set), we count the length of the sequence. We keep track of the maximum length found.
*/ 