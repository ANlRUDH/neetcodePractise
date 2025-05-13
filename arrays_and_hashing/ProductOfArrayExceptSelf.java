/*
LeetCode 238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
*/

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 1;
        for (int i = 0; i < n; i++) {
            res[i] = left;
            left *= nums[i];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        
        // Test case 1: Positive numbers
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(nums1);
        System.out.println("Test case 1: " + Arrays.toString(result1)); // Expected: [24, 12, 8, 6]
        
        // Test case 2: Array with zero
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solution.productExceptSelf(nums2);
        System.out.println("Test case 2: " + Arrays.toString(result2)); // Expected: [0, 0, 9, 0, 0]
        
        // Test case 3: Two elements
        int[] nums3 = {2, 3};
        int[] result3 = solution.productExceptSelf(nums3);
        System.out.println("Test case 3: " + Arrays.toString(result3)); // Expected: [3, 2]
        
        // Test case 4: All same numbers
        int[] nums4 = {2, 2, 2, 2};
        int[] result4 = solution.productExceptSelf(nums4);
        System.out.println("Test case 4: " + Arrays.toString(result4)); // Expected: [8, 8, 8, 8]
    }
}

/*
Explanation:
We use two passes. In the first pass, we calculate the product of all elements to the left of each index. In the second pass, we multiply by the product of all elements to the right. This avoids using division and achieves O(n) time complexity.
*/ 