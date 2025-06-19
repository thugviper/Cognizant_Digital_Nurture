# Understanding Recursion
Recursion is a technique where a method calls itself to solve a problem by breaking it down into smaller sub-problems. To do this , it uses Stack data structure to extend 
and backtrack to multiple function calls, and solve them.

### Why recursion
- *Simplifies problems that are naturally repetitive* 
- *Reduces code complexity for hierarchical/step-based calculations*


## Recursive future value calculation

For our future predictions , we use a simple formula based on initial value n, rate of growth/decrease r, and time in years t.

formula : f(n) = f(n-1) * (1 + r)
As each call takes constant time , n calls takes o(n) time and o(n) space.




