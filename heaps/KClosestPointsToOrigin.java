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
import java.util.Arrays;

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

    public static void main(String[] args) {
        KClosestPointsToOrigin solution = new KClosestPointsToOrigin();
        
        // Test case 1: Basic case
        int[][] points1 = {{1, 3}, {-2, 2}};
        int k1 = 1;
        System.out.println("Test case 1: " + Arrays.deepToString(solution.kClosest(points1, k1))); // Expected: [[-2,2]]
        
        // Test case 2: Multiple points
        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        int k2 = 2;
        System.out.println("Test case 2: " + Arrays.deepToString(solution.kClosest(points2, k2))); // Expected: [[3,3],[-2,4]]
        
        // Test case 3: Single point
        int[][] points3 = {{1, 1}};
        int k3 = 1;
        System.out.println("Test case 3: " + Arrays.deepToString(solution.kClosest(points3, k3))); // Expected: [[1,1]]
        
        // Test case 4: k equals array length
        int[][] points4 = {{1, 1}, {2, 2}, {3, 3}};
        int k4 = 3;
        System.out.println("Test case 4: " + Arrays.deepToString(solution.kClosest(points4, k4))); // Expected: [[1,1],[2,2],[3,3]]
        
        // Test case 5: Points with same distance
        int[][] points5 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int k5 = 2;
        System.out.println("Test case 5: " + Arrays.deepToString(solution.kClosest(points5, k5))); // Expected: Any two points with distance 1
    }
}

/*
Explanation:
We use a max-heap of size k to keep the k closest points. For each point, calculate its distance and maintain the heap.
*/ 