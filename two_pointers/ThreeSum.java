/*
LeetCode 15. 3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = [0,1,1]
Output: []

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
*/

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        
        // Test case 1: Basic case with multiple solutions
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result1 = solution.threeSum(nums1);
        System.out.println("Test case 1: " + result1); // Expected: [[-1,-1,2],[-1,0,1]]
        
        // Test case 2: No solution
        int[] nums2 = {0, 1, 1};
        List<List<Integer>> result2 = solution.threeSum(nums2);
        System.out.println("Test case 2: " + result2); // Expected: []
        
        // Test case 3: All zeros
        int[] nums3 = {0, 0, 0};
        List<List<Integer>> result3 = solution.threeSum(nums3);
        System.out.println("Test case 3: " + result3); // Expected: [[0,0,0]]
        
        // Test case 4: Larger array with multiple solutions
        int[] nums4 = {-2, -1, 0, 1, 2, 3};
        List<List<Integer>> result4 = solution.threeSum(nums4);
        System.out.println("Test case 4: " + result4); // Expected: [[-2,-1,3],[-2,0,2],[-1,0,1]]
        
        // Test case 5: Array with duplicates
        int[] nums5 = {-1, -1, -1, 0, 1, 1, 1};
        List<List<Integer>> result5 = solution.threeSum(nums5);
        System.out.println("Test case 5: " + result5); // Expected: [[-1,-1,2],[-1,0,1]]
    }
}

/*
Explanation:
Sort the array. For each number, use two pointers to find pairs that sum to the negative of the current number. Skip duplicates to ensure unique triplets.
*/ 