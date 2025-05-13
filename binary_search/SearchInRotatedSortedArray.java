/*
LeetCode 33. Search in Rotated Sorted Array

There is an integer array nums sorted in ascending order (with distinct values), which is rotated at an unknown pivot. Given the array nums and an integer target, return the index of target if it is in nums, or -1 if it is not in nums. You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1
*/

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        
        // Test case 1: Target exists
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Test case 1: " + solution.search(nums1, target1)); // Expected: 4
        
        // Test case 2: Target doesn't exist
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("Test case 2: " + solution.search(nums2, target2)); // Expected: -1
        
        // Test case 3: Single element
        int[] nums3 = {1};
        int target3 = 0;
        System.out.println("Test case 3: " + solution.search(nums3, target3)); // Expected: -1
        
        // Test case 4: Target at start
        int[] nums4 = {4, 5, 6, 7, 0, 1, 2};
        int target4 = 4;
        System.out.println("Test case 4: " + solution.search(nums4, target4)); // Expected: 0
        
        // Test case 5: Target at end
        int[] nums5 = {4, 5, 6, 7, 0, 1, 2};
        int target5 = 2;
        System.out.println("Test case 5: " + solution.search(nums5, target5)); // Expected: 6
    }
}

/*
Explanation:
We use binary search. Determine which side is sorted, and check if the target is within that side. Adjust the search range accordingly.
*/ 