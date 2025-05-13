Arrays & Hashing - Study Notes
=============================

Key Concepts:
-------------
- Arrays: Fixed-size, indexed collections. Fast access, but resizing is costly.
- Hash Maps: Key-value storage for fast lookup, insertion, and deletion (average O(1)).
- Hash Sets: Store unique elements, fast membership checks.
- Frequency Counting: Use hash maps/arrays to count occurrences of elements.
- Sorting: Useful for grouping, deduplication, and two-pointer techniques.
- Prefix Sums: Precompute cumulative sums for fast range queries.

Patterns & Tricks:
------------------
- Use hash sets to check for duplicates or membership in O(1) time.
- Use hash maps for grouping (e.g., anagrams) or frequency analysis.
- Sliding window and two-pointer techniques often combine with arrays and hashing.
- Sorting can simplify problems (e.g., grouping, finding consecutive sequences).
- For Sudoku/board problems, use sets to track seen values in rows, columns, and boxes.

What to Master:
---------------
- Implementing and using hash maps/sets in Java (HashMap, HashSet).
- Recognizing when to use arrays vs. hash-based structures.
- Efficient iteration and in-place modification of arrays.
- Handling edge cases: empty arrays, duplicates, negative numbers, etc.
- Common interview problems: Two Sum, Valid Anagram, Group Anagrams, Top K Frequent Elements, Product of Array Except Self, Valid Sudoku, Longest Consecutive Sequence.

Practice:
---------
- Write code to count frequencies, find duplicates, and group elements.
- Practice problems involving prefix sums and subarrays.
- Get comfortable with Java's collection framework (ArrayList, HashMap, HashSet).

Interview Tips:
---------------
- Always clarify constraints (array size, value range, duplicates allowed?).
- Think about time and space trade-offs (can you use extra space?).
- Hashing is powerful for O(1) lookups—use it for membership and frequency problems.
- For grouping, use map of lists (e.g., Map<String, List<String>> for anagrams). 