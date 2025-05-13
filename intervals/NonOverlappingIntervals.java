/*
LeetCode 435. Non-overlapping Intervals

Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: Remove [1,3] then the rest of the intervals are non-overlapping.

Example 2:
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2

Example 3:
Input: intervals = [[1,2],[2,3]]
Output: 0
*/

import java.util.*;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals solution = new NonOverlappingIntervals();
        
        // Test case 1: One interval to remove
        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Test case 1: " + solution.eraseOverlapIntervals(intervals1)); // Expected: 1
        
        // Test case 2: Multiple overlapping intervals
        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println("Test case 2: " + solution.eraseOverlapIntervals(intervals2)); // Expected: 2
        
        // Test case 3: No overlapping intervals
        int[][] intervals3 = {{1, 2}, {2, 3}};
        System.out.println("Test case 3: " + solution.eraseOverlapIntervals(intervals3)); // Expected: 0
        
        // Test case 4: Empty array
        int[][] intervals4 = {};
        System.out.println("Test case 4: " + solution.eraseOverlapIntervals(intervals4)); // Expected: 0
        
        // Test case 5: Complex overlapping
        int[][] intervals5 = {{1, 4}, {2, 3}, {3, 5}, {4, 6}};
        System.out.println("Test case 5: " + solution.eraseOverlapIntervals(intervals5)); // Expected: 2
    }
}

/*
Explanation:
Sort intervals by end time. Use a greedy approach to select the maximum number of non-overlapping intervals. The answer is the total number minus the count of non-overlapping intervals.
*/ 