Sliding Window - Study Notes
===========================

Key Concepts:
-------------
- Sliding Window: Technique to maintain a window (subarray or substring) over a sequence and move it efficiently.
- Fixed Window: Window size is constant (e.g., max sum of k-length subarray).
- Variable Window: Window size changes based on constraints (e.g., longest substring without repeating characters).
- Frequency Map: Use hash maps/arrays to track counts of elements in the window.

Patterns & Tricks:
------------------
- Use two pointers (left/right) to define the window.
- Expand the right pointer to grow the window, move the left pointer to shrink it.
- For substring/array problems, update frequency maps as the window moves.
- For minimum/maximum window problems, update the result when constraints are met.

What to Master:
---------------
- Implementing both fixed and variable window patterns.
- Efficiently updating frequency maps or counters.
- Handling edge cases: empty string/array, window larger than input.
- Common interview problems: Best Time to Buy and Sell Stock, Longest Substring Without Repeating Characters, Longest Repeating Character Replacement, Permutation in String, Minimum Window Substring, Sliding Window Maximum.

Practice:
---------
- Write code for both fixed and variable window problems.
- Practice updating and maintaining frequency maps.

Interview Tips:
---------------
- Draw the window and update steps to visualize the process.
- Be careful with window boundaries and off-by-one errors.
- Always check if the window meets the problem's constraints before updating the result. 