/*
LeetCode 4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.0

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.5
*/

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;
            int maxLeftA = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRightA = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int maxLeftB = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRightB = (j == n) ? Integer.MAX_VALUE : nums2[j];
            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}

/*
Explanation:
We use binary search to partition the two arrays such that the left half contains the smaller elements and the right half contains the larger elements. The median is then calculated based on the partition.
*/ 