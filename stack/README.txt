Stack - Study Notes
==================

Key Concepts:
-------------
- Stack: LIFO (Last-In, First-Out) data structure. Supports push, pop, peek/top operations.
- Monotonic Stack: Stack that maintains elements in increasing or decreasing order. Useful for next greater/smaller element problems.
- Parentheses Matching: Use stacks to check for valid parentheses or to evaluate expressions.
- Backtracking: Stacks can help with undo operations or recursive backtracking.

Patterns & Tricks:
------------------
- Use stacks to reverse order, track previous elements, or manage nested structures.
- For histogram/temperature problems, use a monotonic stack to find the next greater element.
- For expression evaluation, use stacks to manage operators and operands.

What to Master:
---------------
- Implementing stack operations in Java (Stack, Deque).
- Recognizing when to use a stack for nested or sequential problems.
- Handling edge cases: empty stack, stack overflow, invalid input.
- Common interview problems: Valid Parentheses, Min Stack, Evaluate Reverse Polish Notation, Generate Parentheses, Daily Temperatures, Car Fleet, Largest Rectangle in Histogram.

Practice:
---------
- Write code for parentheses matching, next greater element, and custom stack classes.
- Practice with both array-based and linked-list-based stacks.

Interview Tips:
---------------
- Draw the stack at each step to visualize the process.
- Be careful with stack underflow (popping from an empty stack).
- Monotonic stacks are powerful for range queries and sliding window problems. 