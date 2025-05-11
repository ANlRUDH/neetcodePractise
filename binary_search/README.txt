Binary Search - Study Notes
==========================

Key Concepts:
-------------
- Binary Search: Efficiently search a sorted array by repeatedly dividing the search interval in half (O(log n)).
- Search on Answer: Use binary search to find the minimum/maximum feasible value (e.g., Koko Eating Bananas, capacity to ship packages).
- Rotated Arrays: Binary search can be adapted to rotated sorted arrays.
- Lower/Upper Bound: Find the first/last occurrence of a value.

Patterns & Tricks:
------------------
- Always check if the array is sorted or can be made monotonic.
- Use binary search for problems asking for existence, position, or optimal value.
- For 2D matrices, treat as 1D or use row/column binary search.
- For search on answer, define the search space and check feasibility with a helper function.

What to Master:
---------------
- Implementing classic binary search (iterative and recursive).
- Handling edge cases: empty array, single element, duplicates.
- Adapting binary search to rotated arrays and 2D matrices.
- Common interview problems: Binary Search, Search a 2D Matrix, Koko Eating Bananas, Find Minimum in Rotated Sorted Array, Search in Rotated Sorted Array, Median of Two Sorted Arrays.

Practice:
---------
- Write code for lower/upper bound, search on answer, and rotated array search.
- Practice with both integer and floating-point search spaces.

Interview Tips:
---------------
- Watch for off-by-one errors (left/right boundaries).
- Always check the loop condition and update rules.
- Draw the search space and mid calculation to avoid infinite loops. 