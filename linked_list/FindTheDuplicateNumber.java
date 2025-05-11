/*
LeetCode 287. Find the Duplicate Number

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive, there is only one repeated number in nums. Return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3
*/

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

/*
Explanation:
We use Floyd's Tortoise and Hare (cycle detection) algorithm. Treat the array as a linked list where the value points to the next index. The duplicate forms a cycle.
*/ 