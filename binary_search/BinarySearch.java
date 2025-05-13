/*
LeetCode 704. Binary Search

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
*/

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        
        // Test case 1: Target exists
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        System.out.println("Test case 1: " + solution.search(nums1, target1)); // Expected: 4
        
        // Test case 2: Target doesn't exist
        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 2;
        System.out.println("Test case 2: " + solution.search(nums2, target2)); // Expected: -1
        
        // Test case 3: Target at start
        int[] nums3 = {1, 2, 3, 4, 5};
        int target3 = 1;
        System.out.println("Test case 3: " + solution.search(nums3, target3)); // Expected: 0
        
        // Test case 4: Target at end
        int[] nums4 = {1, 2, 3, 4, 5};
        int target4 = 5;
        System.out.println("Test case 4: " + solution.search(nums4, target4)); // Expected: 4
        
        // Test case 5: Empty array
        int[] nums5 = {};
        int target5 = 1;
        System.out.println("Test case 5: " + solution.search(nums5, target5)); // Expected: -1
    }
}

/*
Explanation:
We use the binary search algorithm. Set left and right pointers, check the middle value, and adjust the pointers based on comparison. Repeat until found or pointers cross.
*/ 