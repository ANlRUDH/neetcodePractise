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
}

/*
Explanation:
Use a greedy approach. Track the farthest you can reach and increment jumps when you reach the end of the current jump range.
*/ 