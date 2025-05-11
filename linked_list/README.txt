Linked List - Study Notes
========================

Key Concepts:
-------------
- Linked List: Sequence of nodes where each node points to the next (singly) or both next and previous (doubly).
- Singly Linked List: Each node has a value and a next pointer.
- Doubly Linked List: Each node has value, next, and prev pointers.
- Fast/Slow Pointers: Used for cycle detection, finding middle, etc.
- Dummy Node: Simplifies edge cases (e.g., head removal).

Patterns & Tricks:
------------------
- Use fast/slow pointers for cycle detection and finding the middle.
- Use dummy nodes to simplify insertions and deletions.
- Reverse a linked list by changing next pointers.
- Merge two sorted lists by iterating and comparing nodes.
- For LRU cache, combine a doubly linked list with a hash map.

What to Master:
---------------
- Implementing basic operations: insert, delete, reverse, merge.
- Handling edge cases: empty list, single node, head/tail removal.
- Recognizing when to use dummy nodes and fast/slow pointers.
- Common interview problems: Reverse Linked List, Merge Two Sorted Lists, Linked List Cycle, Reorder List, Remove Nth Node From End, Copy List With Random Pointer, Add Two Numbers, Find the Duplicate Number, LRU Cache, Merge K Sorted Lists, Reverse Nodes in K Group.

Practice:
---------
- Write code for reversing, merging, and detecting cycles.
- Practice with both singly and doubly linked lists.

Interview Tips:
---------------
- Draw the list and pointer changes for each operation.
- Be careful with null pointers and edge cases at the head/tail.
- Use dummy nodes to avoid special cases for head operations. 