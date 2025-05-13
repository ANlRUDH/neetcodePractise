/*
LeetCode 53. Maximum Subarray

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:
Input: nums = [1]
Output: 1

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
*/

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        
        // Test case 1: Basic case with positive and negative numbers
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Test case 1: " + solution.maxSubArray(nums1)); // Expected: 6
        
        // Test case 2: Single element
        int[] nums2 = {1};
        System.out.println("Test case 2: " + solution.maxSubArray(nums2)); // Expected: 1
        
        // Test case 3: All positive numbers
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Test case 3: " + solution.maxSubArray(nums3)); // Expected: 23
        
        // Test case 4: All negative numbers
        int[] nums4 = {-2, -3, -1, -5};
        System.out.println("Test case 4: " + solution.maxSubArray(nums4)); // Expected: -1
        
        // Test case 5: Alternating positive and negative
        int[] nums5 = {3, -2, 5, -1, 4, -3, 2};
        System.out.println("Test case 5: " + solution.maxSubArray(nums5)); // Expected: 6
    }
}

/*
Explanation:
Use Kadane's algorithm. For each element, decide to start a new subarray or extend the previous one. Track the maximum sum found.
*/ 