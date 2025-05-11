Heaps - Study Notes
==================

Key Concepts:
-------------
- Heap: Complete binary tree where each node is smaller (min-heap) or larger (max-heap) than its children.
- Min-Heap: Root is the smallest element. Used for finding k smallest/largest elements.
- Max-Heap: Root is the largest element. Used for finding k largest elements.
- Priority Queue: Abstract data type where each element has a priority. Java's PriorityQueue is a min-heap by default.
- Heap Operations: Insert, extract-min/max, heapify, peek.

Patterns & Tricks:
------------------
- Use min-heap for k largest elements (size k), max-heap for k smallest.
- For streaming data, maintain a heap of size k for top-k problems.
- For custom order, use a comparator with PriorityQueue.
- Heaps are useful for merging sorted lists/arrays and scheduling problems.

What to Master:
---------------
- Implementing and using PriorityQueue in Java.
- Building a heap from an array (heapify).
- Handling edge cases: empty heap, duplicate values.
- Common interview problems: Kth Largest Element in a Stream, Last Stone Weight, K Closest Points to Origin, Kth Largest Element in an Array, Task Scheduler, Design Twitter.

Practice:
---------
- Write code for top-k, merging, and scheduling problems using heaps.
- Practice with both min-heap and max-heap (using custom comparators).

Interview Tips:
---------------
- Know how to use Java's PriorityQueue and custom comparators.
- For k largest/smallest, keep the heap size at k for efficiency.
- Draw the heap structure to visualize insertions and removals. 