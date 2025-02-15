package com.Practise.DeltaAirlines;

public class MaxFruitsCollected_Mettl {

    private static int maxFruits = 0;

    public static int maxFruitsCollected(int[][] garden, int x, int y, int k) {
        maxFruits = 0;

        // Convert 1-based indices to 0-based
        x = x - 1;
        y = y - 1;

        // Perform DFS to find the maximum fruits that can be collected
        dfs(garden, x, y, k, 0);
        return maxFruits;
    }

    private static void dfs(int[][] garden, int row, int col, int stepsLeft, int collected) {
        // Base case: No steps left or out of bounds
        if (stepsLeft < 0 || row < 0 || row >= garden.length || col < 0 || col >= garden[0].length) {
            return;
        }

        // Collect fruits from the current cell
        collected += garden[row][col];

        // Update the maximum fruits collected
        maxFruits = Math.max(maxFruits, collected);

        // Save the current cell value and mark it as visited
        int temp = garden[row][col];
        garden[row][col] = 0;

        // Define directions: Right, Down, Left, Up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Recursive DFS call
            dfs(garden, newRow, newCol, stepsLeft - 1, collected);
        }

        // Backtrack: Restore the cell value
        garden[row][col] = temp;
    }

    public static void main(String[] args) {
        // Inputs
        int rows = 3, cols = 4;
        int startX = 3, startY = 3;
        int steps = 3;
        int[][] garden = {
                {2, 1, 4, 2},
                {3, 1, 2, 3},
                {2, 2, 0, 1}
        };

        // Calculate maximum fruits
        int result = maxFruitsCollected(garden, startX, startY, steps);
        System.out.println("Maximum fruits collected: " + result);
    }
}