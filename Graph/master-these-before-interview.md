 **Graphs** are a fundamental data structure in computer science and frequently tested in Software Engineering interviews.

Here are the key graph concepts you should master, along with 5 representative LeetCode problems for each.

## 1. Graph Traversals 🚶‍♀️

Graph traversals are the methods used to visit every vertex in a graph.

### Key Concepts to Master
* **Breadth-First Search (BFS):** Used to find the shortest path in an unweighted graph. It explores neighbors level by level, often implemented using a **queue**.
* **Depth-First Search (DFS):** Used to explore as far as possible along each branch before backtracking. It can be implemented recursively or iteratively using a **stack**.
* **Connected Components:** Identifying subsets of vertices in which every vertex is reachable from every other vertex.

### LeetCode Problems
1.  **BFS:** LeetCode 200 - **Number of Islands**
2.  **DFS:** LeetCode 733 - **Flood Fill**
3.  **BFS/DFS (Level Order):** LeetCode 1091 - **Shortest Path in Binary Matrix**
4.  **Connected Components:** LeetCode 323 - **Number of Connected Components in an Undirected Graph** (Premium, but essential concept) or LeetCode 695 - **Max Area of Island**
5.  **Bi-partiteness Check (using BFS/DFS):** LeetCode 785 - **Is Graph Bipartite?**


---

## 2. Shortest Path Algorithms 🗺️

These algorithms find a path between two vertices such that the sum of the weights of its constituent edges is minimized.

### Key Concepts to Master
* **Dijkstra's Algorithm:** Finds the **shortest paths from a single source** to all other vertices in a graph with **non-negative** edge weights. It uses a **min-priority queue**.
* **Bellman-Ford Algorithm:** Finds the shortest paths from a single source to all other vertices in a graph that **may contain negative edge weights**. It can also **detect negative cycles**.
* **Floyd-Warshall Algorithm:** Finds the **shortest paths between all pairs of vertices** (All-Pairs Shortest Path).

### LeetCode Problems
1.  **Dijkstra's:** LeetCode 743 - **Network Delay Time**
2.  **Dijkstra's (Variation):** LeetCode 1514 - **Path with Maximum Probability**
3.  **Bellman-Ford:** LeetCode 820 - **Cheapest Flights Within K Stops** (Can be solved with Bellman-Ford or a modified BFS/Dijkstra)
4.  **Floyd-Warshall:** LeetCode 1334 - **Find the City With the Smallest Number of Neighbors at a Threshold Distance**
5.  **BFS for Unweighted Shortest Path:** LeetCode 815 - **Bus Routes**

---

## 3. Minimum Spanning Trees (MST) 🌳

A spanning tree of an undirected, connected graph is a subgraph that is a tree and connects all the vertices. A Minimum Spanning Tree is one whose sum of edge weights is the minimum possible.

### Key Concepts to Master
* **Prim's Algorithm:** Builds the MST by starting at an arbitrary vertex and continuously adding the **least-weight edge** connecting a vertex already in the MST to a vertex outside the MST. It uses a **min-priority queue**.
* **Kruskal's Algorithm:** Builds the MST by considering edges in **non-decreasing order of weight** and adding them if they do not form a cycle. It uses the **Disjoint Set Union (DSU) data structure** to efficiently check for cycles.

### LeetCode Problems
1.  **Kruskal's (with DSU):** LeetCode 1584 - **Min Cost to Connect All Points**
2.  **Prim's:** LeetCode 1135 - **Connecting Cities With Minimum Cost** (Premium, but a direct application)
3.  **DSU/Cycle Detection:** LeetCode 684 - **Redundant Connection**
4.  **Kruskal's Variation:** LeetCode 1489 - **Find Critical and Pseudo-Critical Edges in MST**
5.  **DSU for Connectedness:** LeetCode 959 - **Regions Cut By Slashes**

---

## 4. Topological Sort & Cycles 🔄

Applicable only to **Directed Acyclic Graphs (DAGs)**.

### Key Concepts to Master
* **Topological Sort:** A linear ordering of vertices such that for every directed edge $u \rightarrow v$, vertex $u$ comes before vertex $v$ in the ordering. It's often solved using **Kahn's Algorithm (using in-degrees and a queue)** or **DFS**.
* **Cycle Detection:** Essential for determining if a graph is a DAG. In a DFS-based approach, a cycle is detected if a back edge is found (an edge from the current vertex to an ancestor in the DFS recursion stack).

### LeetCode Problems
1.  **Topological Sort (Kahn's):** LeetCode 207 - **Course Schedule**
2.  **Topological Sort (DFS):** LeetCode 210 - **Course Schedule II**
3.  **Cycle Detection in Directed Graph:** LeetCode 621 - **Task Scheduler** (Can be modeled as a dependency graph)
4.  **Topological Sort/Order:** LeetCode 329 - **Longest Increasing Path in a Matrix** (Using DFS with memoization on a conceptual DAG)
5.  **Alien Dictionary:** LeetCode 269 - **Alien Dictionary** (Premium, but the most classic example of building a graph from constraints and performing a topological sort)

---

## 5. Other Advanced Concepts & Variations 💡

These problems involve combining graph concepts with other data structures or unique constraints.

### Key Concepts to Master
* **Bipartite Graphs:** A graph whose vertices can be divided into two disjoint sets such that every edge connects a vertex in one set to one in the other set. (See Problem 5 under Traversals).
* **Graph Modeling:** The ability to convert a non-graph problem (like a grid, a puzzle, or a set of dependencies) into a formal graph structure.
* **State-Space Search:** Using BFS/DFS to explore different states in a problem (e.g., puzzles, minimum moves problems).

### LeetCode Problems
1.  **Graph Modeling (Grid):** LeetCode 994 - **Rotting Oranges** (Classic multi-source BFS problem)
2.  **Disjoint Set Union (DSU):** LeetCode 721 - **Accounts Merge**
3.  **State-Space BFS:** LeetCode 847 - **Shortest Path Visiting All Nodes** (Complex BFS with bitmasking)
4.  **Maximum Flow/Minimum Cut:** LeetCode 2093 - **Minimum Cost to Reach City With Discount** (Rarely asked, but a conceptual example)
5.  **Graph with Backtracking (Permutations):** LeetCode 1799 - **Maximize Score After N Operations** (Using a graph/state model with dynamic programming)

---

Would you like me to elaborate on one of these concepts or discuss how to represent a graph in code (e.g., **Adjacency List vs. Adjacency Matrix**)?
