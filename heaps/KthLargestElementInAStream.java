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

    public static void main(String[] args) {
        // Test case 1: Basic case
        System.out.println("Test case 1:");
        KthLargestElementInAStream kthLargest1 = new KthLargestElementInAStream(3, new int[]{4, 5, 8, 2});
        System.out.println("Initial state: " + kthLargest1.add(3)); // Expected: 4
        System.out.println("After adding 5: " + kthLargest1.add(5)); // Expected: 5
        System.out.println("After adding 10: " + kthLargest1.add(10)); // Expected: 5
        System.out.println("After adding 9: " + kthLargest1.add(9)); // Expected: 8
        System.out.println("After adding 4: " + kthLargest1.add(4)); // Expected: 8
        
        // Test case 2: Empty initial array
        System.out.println("\nTest case 2:");
        KthLargestElementInAStream kthLargest2 = new KthLargestElementInAStream(1, new int[]{});
        System.out.println("After adding 1: " + kthLargest2.add(1)); // Expected: 1
        System.out.println("After adding 2: " + kthLargest2.add(2)); // Expected: 2
        
        // Test case 3: k equals array length
        System.out.println("\nTest case 3:");
        KthLargestElementInAStream kthLargest3 = new KthLargestElementInAStream(2, new int[]{1, 2});
        System.out.println("After adding 3: " + kthLargest3.add(3)); // Expected: 2
        System.out.println("After adding 4: " + kthLargest3.add(4)); // Expected: 3
        
        // Test case 4: All same elements
        System.out.println("\nTest case 4:");
        KthLargestElementInAStream kthLargest4 = new KthLargestElementInAStream(2, new int[]{2, 2, 2});
        System.out.println("After adding 2: " + kthLargest4.add(2)); // Expected: 2
        System.out.println("After adding 3: " + kthLargest4.add(3)); // Expected: 2
        
        // Test case 5: k equals 1
        System.out.println("\nTest case 5:");
        KthLargestElementInAStream kthLargest5 = new KthLargestElementInAStream(1, new int[]{1, 2, 3});
        System.out.println("After adding 4: " + kthLargest5.add(4)); // Expected: 4
        System.out.println("After adding 5: " + kthLargest5.add(5)); // Expected: 5
    }
}

/*
Explanation:
We use a min-heap of size k. The root is always the kth largest element. Add new elements and remove the smallest if the heap exceeds size k.
*/ 