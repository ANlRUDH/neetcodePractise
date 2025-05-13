/*
LeetCode 1851. Minimum Interval to Include Each Query

You are given a 2D integer array intervals, where intervals[i] = [lefti, righti] describes the ith interval starting at lefti and ending at righti (inclusive). You are also given an integer array queries. The answer to the jth query is the size of the smallest interval [lefti, righti] such that lefti <= queries[j] <= righti. If no such interval exists, the answer is -1.

Example 1:
Input: intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5]
Output: [3,3,1,4]

Example 2:
Input: intervals = [[2,3],[2,5],[1,8],[20,25]], queries = [2,19,5,22]
Output: [2,-1,4,6]
*/

import java.util.*;

public class MinimumIntervalToIncludeEachQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = queries.length;
        int[] res = new int[n];
        int[][] q = new int[n][2];
        for (int i = 0; i < n; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0;
        for (int[] query : q) {
            while (i < intervals.length && intervals[i][0] <= query[0]) {
                int len = intervals[i][1] - intervals[i][0] + 1;
                pq.offer(new int[]{len, intervals[i][1]});
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < query[0]) pq.poll();
            res[query[1]] = pq.isEmpty() ? -1 : pq.peek()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumIntervalToIncludeEachQuery solution = new MinimumIntervalToIncludeEachQuery();
        
        // Test case 1: Basic case
        int[][] intervals1 = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries1 = {2, 3, 4, 5};
        System.out.println("Test case 1: " + Arrays.toString(solution.minInterval(intervals1, queries1))); // Expected: [3, 3, 1, 4]
        
        // Test case 2: No interval for some queries
        int[][] intervals2 = {{2, 3}, {2, 5}, {1, 8}, {20, 25}};
        int[] queries2 = {2, 19, 5, 22};
        System.out.println("Test case 2: " + Arrays.toString(solution.minInterval(intervals2, queries2))); // Expected: [2, -1, 4, 6]
        
        // Test case 3: Single interval
        int[][] intervals3 = {{1, 2}};
        int[] queries3 = {1, 2, 3};
        System.out.println("Test case 3: " + Arrays.toString(solution.minInterval(intervals3, queries3))); // Expected: [2, 2, -1]
        
        // Test case 4: Empty intervals
        int[][] intervals4 = {};
        int[] queries4 = {1, 2, 3};
        System.out.println("Test case 4: " + Arrays.toString(solution.minInterval(intervals4, queries4))); // Expected: [-1, -1, -1]
        
        // Test case 5: Overlapping intervals
        int[][] intervals5 = {{1, 3}, {2, 4}, {3, 5}};
        int[] queries5 = {2, 3, 4};
        System.out.println("Test case 5: " + Arrays.toString(solution.minInterval(intervals5, queries5))); // Expected: [2, 2, 2]
    }
}

/*
Explanation:
Sort intervals and queries. For each query, add all intervals that start before or at the query to a min-heap (by length). Remove intervals from the heap that end before the query. The top of the heap is the smallest interval covering the query.
*/ 