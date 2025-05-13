/*
LeetCode 217. Contains Duplicate

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
*/

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        
        // Test case 1: Array with duplicate
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Test case 1: " + solution.containsDuplicate(nums1)); // Expected: true
        
        // Test case 2: Array without duplicate
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Test case 2: " + solution.containsDuplicate(nums2)); // Expected: false
        
        // Test case 3: Array with multiple duplicates
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Test case 3: " + solution.containsDuplicate(nums3)); // Expected: true
    }
}

/*
Explanation:
We use a HashSet to keep track of the numbers we have seen so far. As we iterate through the array, if we encounter a number that is already in the set, we return true (since it is a duplicate). If we finish iterating without finding any duplicates, we return false.
*/ 