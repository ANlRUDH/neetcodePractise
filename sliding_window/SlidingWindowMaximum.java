/*
LeetCode 239. Sliding Window Maximum

You are given an array of integers nums, and there is a sliding window of size k which moves from the very left of the array to the very right. You can only see the k numbers in the window. Each time the window moves right by one position. Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]

Example 2:
Input: nums = [1], k = 1
Output: [1]
*/

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.offerLast(i);
            if (i >= k - 1) res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }
}

/*
Explanation:
We use a deque to keep indices of useful elements for the current window. Remove indices out of the window and those whose values are less than the current value. The front of the deque is the max for the window.
*/ 