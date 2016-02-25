# EightPuzzlewithAI
Artificial Intelligence Project using Java which solves the 8-Puzzle Board 
<html>
<head></head>
<body>
<p><strong>
This was one of the projects from Artificial Intelligence Class "CS363" at Queens College, CUNY(Spring, 2016). 
what</strong></p>
Following are the guidelines which was provided by the professor:
<p>
Artificial Intelligence
Programming Assignment # 1
Heuristic Search
Due before class, Friday, Feb. 19, 2016
Introduction
 On page 103 of your textbook, you will find a diagram of the 8-puzzle. Your
work for this assignment is to implement several search techniques to find the shortest
path between the start state and the goal state.
</p>
<p>
Programming Assignment
</p>
<p>Here is the goal state and four start states for the 8-puzzle.</p>
<p>Goal:&nbsp&nbspEasy:&nbsp&nbsp Medium:&nbsp&nbspHard:&nbsp&nbspWorst:</p>
<p>1&nbsp2&nbsp3&nbsp&nbsp&nbsp1&nbsp3&nbsp4&nbsp&nbsp&nbsp2&nbsp8&nbsp1&nbsp&nbsp&nbsp2&nbsp8&nbsp1&nbsp&nbsp&nbsp5&nbsp6&nbsp7</p>
<p>8&nbsp&nbsp&nbsp&nbsp4&nbsp&nbsp&nbsp8&nbsp6&nbsp2&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp4&nbsp3&nbsp&nbsp&nbsp4&nbsp6&nbsp3&nbsp&nbsp&nbsp4&nbsp&nbsp&nbsp8</p>
<p>7&nbsp6&nbsp5&nbsp&nbsp&nbsp7&nbsp&nbsp&nbsp&nbsp5&nbsp&nbsp&nbsp&nbsp7&nbsp6&nbsp5&nbsp&nbsp&nbsp&nbsp&nbsp7&nbsp5&nbsp&nbsp&nbsp3&nbsp2&nbsp1</p>

<p>Implement the following search algorithms and test them on the start states and goal
state shown above. All algorithms except IDA* will need to be able to detect duplicate
states and eliminate them from the remainder of the search.</p>
<ul>
<li>1. A* search using the heuristic function f*(n) = g(n) + h*(n), where h*(n) is the
number of tiles out of place (not counting the blank).</li>
<li>2. A* search using the Manhattan heuristic function.</li>
<li>3. Iterative deepening A* with the Manhattan heuristic function.</li>
<li>4. Depth-first Branch and Bound with the Manhattan heuristic function.</li>
</ul>
<p>
When defining the successor function, it is helpful to define the actions in terms of
the empty tile, that is, the four actions are moving the empty tile right, down, left, and
up. Consider the actions in this order in your implementation.
</p>
<p>
If your algorithms take too long or too much memory to find any solution, your
implementation may be inefficient. Consider optimizing it. If you still can’t find solutions
within a reasonable amount of time, enforce a time limit, say 30 minutes, on your
algorithm and specify it in your report.
</p>
<strong>
Problem Analysis:
</strong>
<p>
For all the algorithms, include in your report a table the number of nodes expanded,
the total time required to solve the puzzle, and the sequence of moves in the optimal
solution. For Depth-first Branch and Bound, also record the time the optimal solution is
found (typically not the same as the finish time).
</p>
Besides, answer the following questions:
<ul>

<li>1. What is the number of possible states of the board?</li>
<li>2. What is the average number of possible moves from a given position of the board? </li>
<li>3. Estimate how many moves might be required for an optimal (minimum number of
moves) solution to a “worst-case” problem (maximum distance between starting and
goal states). Explain how you made your estimate (Note this is an open-ended
question; any logical answer may suffice).</li>
<li>4. Assuming the answer to question #2 is the “average branching factor” and a depth as
in the answer to question #3, estimate the number of nodes that would have to be
examined to find an answer by the brute force breadth-first search.</li>
<li>5. Assuming that your computer can examine one move per millisecond, would such a
blind-search solution to the problem terminate before the end of the semester?</li>
<li>6. The “worst” example problem given above is actually one of the easiest for humans to
solve. Why do you think that is the case? What lessons for AI programs are suggested
by this difference between human performance and performance of your search
program?</li>
<li>7. Compare A*, DFBnB, and IDA* and discuss their advantages and disadvantages.</li>
</ul>

<strong>Deliverables:</strong>
<p>
Send a single .zip file named LastName.FirstInitial.HW# containing the following
to the instructor:
</p>
<ul>
<li>1) Well commented code;</li>
<li>2) A readme file explaining how to compile and run your code;</li>
<li>3) A written report explaining your experimental results and analysis.</li>
</ul>
<p>
Also submit the report in hardcopy before the class.
Academic honesty: Please do your own work; do not give or receive any assistance in
implementing the algorithms. 
</p>
</body></html>
