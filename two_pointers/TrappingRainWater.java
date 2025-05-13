/*
LeetCode 42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
*/

public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        // Test case 1: Example from problem
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Test case 1: " + solution.trap(height1)); // Expected: 6

        // Test case 2: Another example
        int[] height2 = {4,2,0,3,2,5};
        System.out.println("Test case 2: " + solution.trap(height2)); // Expected: 9

        // Test case 3: No bars
        int[] height3 = {};
        System.out.println("Test case 3: " + solution.trap(height3)); // Expected: 0

        // Test case 4: All bars same height
        int[] height4 = {2,2,2,2};
        System.out.println("Test case 4: " + solution.trap(height4)); // Expected: 0

        // Test case 5: Decreasing heights
        int[] height5 = {5,4,3,2,1};
        System.out.println("Test case 5: " + solution.trap(height5)); // Expected: 0

        // Test case 6: Increasing heights
        int[] height6 = {1,2,3,4,5};
        System.out.println("Test case 6: " + solution.trap(height6)); // Expected: 0
    }
}

/*
Explanation:
We use two pointers and keep track of the maximum height to the left and right. Water trapped at each position is determined by the minimum of leftMax and rightMax minus the current height.
*/ 