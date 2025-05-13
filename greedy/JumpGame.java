/*
LeetCode 55. Jump Game

Given an array of non-negative integers nums, you are initially positioned at the first index of the array. Each element in the array represents your maximum jump length at that position. Determine if you are able to reach the last index.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
*/

public class JumpGame {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) return false;
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        
        // Test case 1: Can reach the end
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Test case 1: " + solution.canJump(nums1)); // Expected: true
        
        // Test case 2: Cannot reach the end
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Test case 2: " + solution.canJump(nums2)); // Expected: false
        
        // Test case 3: Single element
        int[] nums3 = {0};
        System.out.println("Test case 3: " + solution.canJump(nums3)); // Expected: true
        
        // Test case 4: All zeros except last
        int[] nums4 = {0, 0, 0, 1};
        System.out.println("Test case 4: " + solution.canJump(nums4)); // Expected: false
        
        // Test case 5: Large jumps
        int[] nums5 = {5, 0, 0, 0, 0};
        System.out.println("Test case 5: " + solution.canJump(nums5)); // Expected: true
    }
}

/*
Explanation:
Track the farthest index you can reach. If you reach an index greater than the farthest, return false. If you finish the loop, you can reach the end.
*/ 