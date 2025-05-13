/*
LeetCode 153. Find Minimum in Rotated Sorted Array

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. Given the rotated array nums, return the minimum element of this array.
You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [3,4,5,1,2]
Output: 1

Example 2:
Input: nums = [4,5,6,7,0,1,2]
Output: 0

Example 3:
Input: nums = [11,13,15,17]
Output: 11
*/

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray solution = new FindMinimumInRotatedSortedArray();
        
        // Test case 1: Basic rotation
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Test case 1: " + solution.findMin(nums1)); // Expected: 1
        
        // Test case 2: Multiple rotations
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Test case 2: " + solution.findMin(nums2)); // Expected: 0
        
        // Test case 3: No rotation
        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Test case 3: " + solution.findMin(nums3)); // Expected: 11
        
        // Test case 4: Single element
        int[] nums4 = {1};
        System.out.println("Test case 4: " + solution.findMin(nums4)); // Expected: 1
        
        // Test case 5: Two elements
        int[] nums5 = {2, 1};
        System.out.println("Test case 5: " + solution.findMin(nums5)); // Expected: 1
    }
}

/*
Explanation:
We use binary search. If the middle element is greater than the rightmost, the minimum is to the right. Otherwise, it's to the left or at mid. Continue until left == right.
*/ 