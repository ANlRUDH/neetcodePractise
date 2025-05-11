Trees - Study Notes
==================

Key Concepts:
-------------
- Tree: Hierarchical data structure with nodes and edges. Each node has zero or more children.
- Binary Tree: Each node has at most two children (left and right).
- Binary Search Tree (BST): Left child < parent < right child for all nodes.
- Traversals: Preorder, Inorder, Postorder, Level Order (BFS).
- Recursion: Most tree problems are solved recursively.

Patterns & Tricks:
------------------
- Use recursion for traversals and divide-and-conquer problems.
- Use queues for level order (BFS) and stacks for iterative traversals.
- For path problems, pass state (e.g., depth, sum) as function arguments.
- For serialization/deserialization, use preorder or level order.
- For LCA, use recursion to find the split point.

What to Master:
---------------
- Implementing all tree traversals (recursive and iterative).
- Building trees from traversals (preorder/inorder, etc.).
- Recognizing BST properties and using them for efficient search.
- Handling edge cases: empty tree, single node, skewed trees.
- Common interview problems: Invert Binary Tree, Maximum Depth, Diameter, Balanced Tree, Same Tree, Subtree, LCA, Level Order Traversal, Right Side View, Count Good Nodes, Validate BST, Kth Smallest, Construct Tree from Traversals, Max Path Sum, Serialize/Deserialize.

Practice:
---------
- Write code for all traversals and tree construction.
- Practice recursive and iterative solutions.

Interview Tips:
---------------
- Draw the tree and recursive calls to visualize the process.
- Be careful with null nodes and base cases.
- For BSTs, leverage the sorted property for efficient solutions. 