/*
LeetCode 56. Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = intervals[i];
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();
        
        // Test case 1: Basic overlapping intervals
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Test case 1: " + Arrays.deepToString(solution.merge(intervals1))); // Expected: [[1,6],[8,10],[15,18]]
        
        // Test case 2: Adjacent intervals
        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.println("Test case 2: " + Arrays.deepToString(solution.merge(intervals2))); // Expected: [[1,5]]
        
        // Test case 3: Single interval
        int[][] intervals3 = {{1, 2}};
        System.out.println("Test case 3: " + Arrays.deepToString(solution.merge(intervals3))); // Expected: [[1,2]]
        
        // Test case 4: Empty array
        int[][] intervals4 = {};
        System.out.println("Test case 4: " + Arrays.deepToString(solution.merge(intervals4))); // Expected: []
        
        // Test case 5: All intervals overlap
        int[][] intervals5 = {{1, 4}, {2, 5}, {3, 6}};
        System.out.println("Test case 5: " + Arrays.deepToString(solution.merge(intervals5))); // Expected: [[1,6]]
    }
}

/*
Explanation:
Sort the intervals by start time. Merge overlapping intervals by comparing the current interval's end with the next interval's start. Add merged intervals to the result list.
*/ 