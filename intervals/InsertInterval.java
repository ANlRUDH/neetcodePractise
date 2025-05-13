/*
LeetCode 57. Insert Interval

You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] sorted by starti and a new interval newInterval = [start, end].
Insert newInterval into intervals such that intervals is still sorted in order and non-overlapping (merge if necessary).

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Intervals [3,5],[6,7],[8,10] are merged with [4,8].
*/

import java.util.*;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;
        // Add all intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }
        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        // Add remaining intervals
        while (i < n) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval solution = new InsertInterval();
        
        // Test case 1: Basic insertion
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        System.out.println("Test case 1: " + Arrays.deepToString(solution.insert(intervals1, newInterval1))); // Expected: [[1,5],[6,9]]
        
        // Test case 2: Multiple merges
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        System.out.println("Test case 2: " + Arrays.deepToString(solution.insert(intervals2, newInterval2))); // Expected: [[1,2],[3,10],[12,16]]
        
        // Test case 3: Insert at beginning
        int[][] intervals3 = {{2, 3}, {4, 5}};
        int[] newInterval3 = {0, 1};
        System.out.println("Test case 3: " + Arrays.deepToString(solution.insert(intervals3, newInterval3))); // Expected: [[0,1],[2,3],[4,5]]
        
        // Test case 4: Insert at end
        int[][] intervals4 = {{1, 2}, {3, 4}};
        int[] newInterval4 = {5, 6};
        System.out.println("Test case 4: " + Arrays.deepToString(solution.insert(intervals4, newInterval4))); // Expected: [[1,2],[3,4],[5,6]]
        
        // Test case 5: Empty intervals
        int[][] intervals5 = {};
        int[] newInterval5 = {1, 2};
        System.out.println("Test case 5: " + Arrays.deepToString(solution.insert(intervals5, newInterval5))); // Expected: [[1,2]]
    }
}

/*
Explanation:
Iterate through the intervals. Add all intervals that end before the new interval. Merge all overlapping intervals with the new interval. Add the merged interval. Finally, add the rest of the intervals.
*/ 