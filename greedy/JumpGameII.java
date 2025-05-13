/*
LeetCode 45. Jump Game II

Given an array of non-negative integers nums, you are initially positioned at the first index of the array. Each element in the array represents your maximum jump length at that position. Return the minimum number of jumps to reach the last index. Assume you can always reach the last index.

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2
*/

public class JumpGameII {
    public int jump(int[] nums) {
        int jumps = 0, end = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGameII solution = new JumpGameII();
        
        // Test case 1: Basic case
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Test case 1: " + solution.jump(nums1)); // Expected: 2
        
        // Test case 2: Another basic case
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println("Test case 2: " + solution.jump(nums2)); // Expected: 2
        
        // Test case 3: Single element
        int[] nums3 = {0};
        System.out.println("Test case 3: " + solution.jump(nums3)); // Expected: 0
        
        // Test case 4: Minimum jumps needed
        int[] nums4 = {1, 2, 3, 4, 5};
        System.out.println("Test case 4: " + solution.jump(nums4)); // Expected: 3
        
        // Test case 5: Large jumps
        int[] nums5 = {5, 0, 0, 0, 0};
        System.out.println("Test case 5: " + solution.jump(nums5)); // Expected: 1
    }
}

/*
Explanation:
Use a greedy approach. Track the farthest you can reach and increment jumps when you reach the end of the current jump range.
*/ 