Intervals - Study Notes
======================

Key Concepts:
-------------
- Interval: A range represented by a start and end value (e.g., [start, end]).
- Merging Intervals: Combine overlapping intervals into one.
- Inserting Intervals: Add a new interval and merge if necessary.
- Sweep Line: Process events in sorted order (start/end points).
- Sorting: Sort intervals by start or end to simplify merging and overlap checks.

Patterns & Tricks:
------------------
- Always sort intervals by start (or end) before merging or processing.
- Use a result list to build merged intervals.
- For meeting rooms, use separate arrays for start and end times and two pointers.
- For minimum interval covering queries, use a heap to track the smallest covering interval.

What to Master:
---------------
- Implementing merge, insert, and erase overlap operations.
- Handling edge cases: empty input, fully overlapping, touching intervals.
- Recognizing when to use sorting and/or heaps.
- Common interview problems: Insert Interval, Merge Intervals, Non Overlapping Intervals, Meeting Rooms I & II, Minimum Interval to Include Each Query.

Practice:
---------
- Write code for merging, inserting, and removing intervals.
- Practice with both open and closed intervals.

Interview Tips:
---------------
- Draw the intervals and merging steps to visualize the process.
- Be careful with inclusive/exclusive endpoints.
- For sweep line, process all events in sorted order and track active intervals. 