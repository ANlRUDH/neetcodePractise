/*
LeetCode 1046. Last Stone Weight

You are given an array of integers stones where stones[i] is the weight of the ith stone.
We repeatedly smash the two heaviest stones together. If they are equal, both are destroyed. If not, the heavier one is replaced by the difference. Return the weight of the last remaining stone. If there are no stones left, return 0.

Example 1:
Input: stones = [2,7,4,1,8,1]
Output: 1

Example 2:
Input: stones = [1]
Output: 1
*/

import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) maxHeap.offer(stone);
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (y != x) maxHeap.offer(y - x);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        LastStoneWeight solution = new LastStoneWeight();
        
        // Test case 1: Basic case
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        System.out.println("Test case 1: " + solution.lastStoneWeight(stones1)); // Expected: 1
        
        // Test case 2: Single stone
        int[] stones2 = {1};
        System.out.println("Test case 2: " + solution.lastStoneWeight(stones2)); // Expected: 1
        
        // Test case 3: All stones equal
        int[] stones3 = {2, 2, 2, 2};
        System.out.println("Test case 3: " + solution.lastStoneWeight(stones3)); // Expected: 0
        
        // Test case 4: Empty array
        int[] stones4 = {};
        System.out.println("Test case 4: " + solution.lastStoneWeight(stones4)); // Expected: 0
        
        // Test case 5: Two stones
        int[] stones5 = {3, 7};
        System.out.println("Test case 5: " + solution.lastStoneWeight(stones5)); // Expected: 4
    }
}

/*
Explanation:
We use a max-heap to always get the two heaviest stones. Smash them and put the difference back if not equal. Repeat until one or zero stones remain.
*/ 