Two Pointers - Study Notes
=========================

Key Concepts:
-------------
- Two pointers: Use two indices to scan through an array or string, often from both ends or with a slow/fast pointer.
- Left/Right Pointer: Start at both ends and move towards each other (e.g., palindrome check, container with most water).
- Fast/Slow Pointer: Move at different speeds to detect cycles or find midpoints (e.g., linked list cycle, removing duplicates).
- Sorted Arrays: Two pointers are especially powerful when the array is sorted (e.g., Two Sum II, Three Sum).

Patterns & Tricks:
------------------
- Move pointers inward to shrink or expand a window.
- Use two pointers to partition arrays or find pairs/triplets with a target sum.
- For removing elements or duplicates, use a slow pointer to build the result in place.
- For problems involving distances or areas, calculate at each step and update the result.

What to Master:
---------------
- Recognizing when two pointers can reduce time complexity from O(n^2) to O(n).
- Implementing left/right and fast/slow pointer patterns.
- Handling edge cases: empty arrays, single element, overlapping pointers.
- Common interview problems: Valid Palindrome, Two Sum II, Three Sum, Container With Most Water, Trapping Rain Water.

Practice:
---------
- Write code for palindrome checks, pair/triplet finding, and window shrinking/expanding.
- Practice with both sorted and unsorted arrays.

Interview Tips:
---------------
- Clarify if the input is sorted—this often enables two pointer solutions.
- Draw diagrams to visualize pointer movement.
- Watch for off-by-one errors and pointer overlap. 