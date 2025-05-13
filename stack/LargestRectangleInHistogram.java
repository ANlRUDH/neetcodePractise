/*
LeetCode 84. Largest Rectangle in Histogram

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10

Example 2:
Input: heights = [2,4]
Output: 4
*/

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();

        // Test case 1: Example from problem
        int[] heights1 = {2,1,5,6,2,3};
        System.out.println("Test case 1: " + solution.largestRectangleArea(heights1)); // Expected: 10

        // Test case 2: Two bars
        int[] heights2 = {2,4};
        System.out.println("Test case 2: " + solution.largestRectangleArea(heights2)); // Expected: 4

        // Test case 3: All bars same height
        int[] heights3 = {3,3,3,3};
        System.out.println("Test case 3: " + solution.largestRectangleArea(heights3)); // Expected: 12

        // Test case 4: Decreasing heights
        int[] heights4 = {5,4,3,2,1};
        System.out.println("Test case 4: " + solution.largestRectangleArea(heights4)); // Expected: 9

        // Test case 5: Single bar
        int[] heights5 = {7};
        System.out.println("Test case 5: " + solution.largestRectangleArea(heights5)); // Expected: 7

        // Test case 6: Empty array
        int[] heights6 = {};
        System.out.println("Test case 6: " + solution.largestRectangleArea(heights6)); // Expected: 0
    }
}

/*
Explanation:
We use a stack to keep indices of the bars. For each bar, we pop from the stack until the current bar is taller. For each popped bar, calculate the area with the popped height as the smallest bar. Track the maximum area found.
*/ 