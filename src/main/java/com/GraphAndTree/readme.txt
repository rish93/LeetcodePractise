Graph
https://github.com/bradtraversy/traversy-js-challenges/blob/main/08-binary-trees-graphs/11-adjacency-matrix-adjacency-list/readme.md

Stack for DFS and Queue for BFS

The choice of using a stack for Depth-First Search (DFS) and a
 queue for Breadth-First Search (BFS) is rooted in how these data
  structures manage the order of node traversal, which directly
  corresponds to the way each algorithm explores the graph or tree.

Why Stack is Used for DFS:

	•	Last-In, First-Out (LIFO): A stack follows a LIFO principle,
	where the last element added is the first one to be removed.
	This fits the nature of DFS, which explores as far as possible
	down a branch before backtracking.
	•	Deep Exploration: When a node is pushed onto the stack,
	 its neighbors (or child nodes) are added next. The most recently
	  discovered neighbor is the first one to be popped from the stack
	  and explored. This behavior naturally leads to deep exploration down
	  a path until no more nodes can be visited in that direction.
	•	Backtracking: When a dead end is reached (i.e., a node has no unvisited neighbors),
	 DFS backtracks to the previous node by popping from the stack and continues exploring from
	 there. The stack structure makes this process efficient.

Example of Stack Behavior in DFS:

Imagine a simple graph like this:

    A
   / \
  B   C
     / \
    D   E

	•	Starting at A, A is pushed onto the stack.
	•	A’s neighbors B and C are pushed, but C is pushed last.
	•	The last-pushed node (C) is explored first, diving deeper into the path (C → D).
	•	After reaching D, DFS continues to E (if D had no unvisited neighbors).
	•	If E has no unvisited neighbors, DFS backtracks through C and then explores other paths like B.

Why Queue is Used for BFS:

	•	First-In, First-Out (FIFO): A queue follows a FIFO principle,
	 where the first element added is the first one to be removed.
	  This fits the nature of BFS, which explores all nodes at the
	   current level before moving to the next level.
	•	Level-by-Level Exploration: BFS processes nodes in the order they are discovered.
	 When a node is dequeued and processed, all its neighbors are enqueued next.
	 This means that nodes closer to the start node are explored before
	 nodes that are farther away.
	•	Breadth Exploration: Since BFS explores nodes level by level,
	 it uses a queue to ensure that nodes discovered earlier are processed
	  before those discovered later.

Example of Queue Behavior in BFS:

For the same graph:

    A
   / \
  B   C
     / \
    D   E

	•	Starting at A, A is enqueued.
	•	A is dequeued and its neighbors B and C are enqueued.
	•	B is dequeued next (as it was enqueued first), and its neighbors are processed.
	•	C is then dequeued, and its neighbors D and E are enqueued.
	•	This order ensures that all nodes at a given “distance” (or level) from A are explored before moving to nodes farther away.

Summary:

	•	Stack for DFS:
	•	Explores deeper paths first before backtracking.
	•	Follows the LIFO principle, suitable for recursion-like behavior.
	•	Naturally supports the depth-first approach.
	•	Queue for BFS:
	•	Explores nodes level by level, ensuring that nodes closer to the source are processed first.
	•	Follows the FIFO principle, suitable for expanding outward from the source.
	•	Ensures that nodes discovered earlier (closer to the start) are processed before nodes discovered later.

Each data structure perfectly matches the traversal strategy of the respective algorithm, making the choice intuitive and efficient for their purposes.