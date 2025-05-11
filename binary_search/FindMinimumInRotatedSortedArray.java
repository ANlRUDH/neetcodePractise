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
}

/*
Explanation:
We use binary search. If the middle element is greater than the rightmost, the minimum is to the right. Otherwise, it's to the left or at mid. Continue until left == right.
*/ 