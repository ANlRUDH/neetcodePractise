/*
LeetCode 11. Container With Most Water

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which together with the x-axis forms a container, such that the container contains the most water.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49

Example 2:
Input: height = [1,1]
Output: 1
*/

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        
        // Test case 1: Basic case with multiple heights
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Test case 1: " + solution.maxArea(height1)); // Expected: 49
        
        // Test case 2: Two equal heights
        int[] height2 = {1, 1};
        System.out.println("Test case 2: " + solution.maxArea(height2)); // Expected: 1
        
        // Test case 3: Increasing heights
        int[] height3 = {1, 2, 3, 4, 5};
        System.out.println("Test case 3: " + solution.maxArea(height3)); // Expected: 6
        
        // Test case 4: Decreasing heights
        int[] height4 = {5, 4, 3, 2, 1};
        System.out.println("Test case 4: " + solution.maxArea(height4)); // Expected: 6
        
        // Test case 5: Alternating heights
        int[] height5 = {4, 3, 2, 1, 4};
        System.out.println("Test case 5: " + solution.maxArea(height5)); // Expected: 16
        
        // Test case 6: Single height
        int[] height6 = {1};
        System.out.println("Test case 6: " + solution.maxArea(height6)); // Expected: 0
    }
}

/*
Explanation:
We use two pointers at the start and end of the array. Calculate the area, move the pointer with the shorter line inward, and keep track of the maximum area found.
*/ 