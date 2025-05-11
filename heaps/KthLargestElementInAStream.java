/*
LeetCode 703. Kth Largest Element in a Stream

Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:
- KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
- int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

Example 1:
Input: ["KthLargest", "add", "add", "add", "add", "add"], [[3, [4,5,8,2]], [3], [5], [10], [9], [4]]
Output: [null, 4, 5, 5, 8, 8]
*/

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    private PriorityQueue<Integer> minHeap;
    private int k;
    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) minHeap.poll();
        return minHeap.peek();
    }
}

/*
Explanation:
We use a min-heap of size k. The root is always the kth largest element. Add new elements and remove the smallest if the heap exceeds size k.
*/ 