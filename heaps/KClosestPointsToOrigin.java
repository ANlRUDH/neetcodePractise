/*
LeetCode 973. K Closest Points to Origin

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
The distance between two points is the Euclidean distance.

Example 1:
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
*/

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
            Integer.compare(distance(b), distance(a)));
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) maxHeap.poll();
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) res[i] = maxHeap.poll();
        return res;
    }
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}

/*
Explanation:
We use a max-heap of size k to keep the k closest points. For each point, calculate its distance and maintain the heap.
*/ 