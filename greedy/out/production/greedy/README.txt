Greedy - Study Notes
===================

Key Concepts:
-------------
- Greedy Algorithm: Make the locally optimal choice at each step, hoping for a global optimum.
- Greedy Choice Property: A global optimum can be reached by choosing the best local option.
- Local vs Global Optimum: Greedy works when local choices lead to the best overall solution.
- Sorting: Often sort input to make greedy choices easier.

Patterns & Tricks:
------------------
- For interval/partition problems, sort and make the best choice at each step.
- For jump/coverage problems, always jump as far as possible.
- For resource allocation, pick the most/least valuable item first.
- Use frequency maps or heaps to make greedy selections efficiently.

What to Master:
---------------
- Recognizing when greedy is optimal (prove with counterexamples or induction).
- Implementing greedy solutions with sorting, heaps, or frequency maps.
- Handling edge cases: empty input, ties, multiple valid solutions.
- Common interview problems: Maximum Subarray, Jump Game I & II, Gas Station, Hand of Straights, Merge Triplets to Form Target Triplet, Partition Labels, Valid Parenthesis String.

Practice:
---------
- Write code for interval scheduling, jump games, and partitioning.
- Practice with both sorted and unsorted inputs.

Interview Tips:
---------------
- Justify why greedy works (prove correctness).
- Draw examples and counterexamples to test your approach.
- Be careful with edge cases and tie-breaking. 