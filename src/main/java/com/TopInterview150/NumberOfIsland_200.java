package com.TopInterview150;


//https://leetcode.com/problems/number-of-islands/solutions/5043875/simpler-easier-fully-explained/

/*
* *  Given an m x n 2D binary grid grid which represents a map of '1's (land)
* *  and '0's (water), return the number of islands.

* *  An island is surrounded by water and is formed by connecting adjacent lands
* *  horizontally or vertically. You may assume all four edges of the grid
* *  are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
* * */


/*Intuition

Traverse the grid elements
increment the count if a land is found,
do dfs on the adjacent elements , while marking it as visited

Approach

Screenshot (51).png

Iterate Through Grid: Iterate through each cell in the grid using two nested loops.

DFS for Each '1' Cell: For each cell that contains a '1' (land) and has not been visited yet,
 start a Depth-First Search (DFS) to mark all connected land cells as visited.

DFS Function: The DFS function takes the grid and the current cell coordinates (i and j)
as input. It checks if the current cell is out of bounds or if it is water ('0').
If so, it returns without doing anything. Otherwise, it marks the current cell as visited
 by changing its value to '0' and recursively calls DFS on its neighboring cells (up, down, left, right).

Increment Island Count: After DFS completes for a particular island,
 increment the count variable by 1 to indicate that an island has been found.

Return Island Count: After iterating through all cells in the grid,
return the final count variable, which represents the total number of islands

Complexity

Time complexity: O(n*m)
Space complexity:O(n*m)
*/

public class NumberOfIsland_200 {

    public static void main(String[] args) {
       char grid[][]= { {'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
       System.out.println(numIslands(grid));
    }

    public  static int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0'; // mark as visited
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
    }
}
