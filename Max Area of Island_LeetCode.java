/*You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if((grid == null) || (grid.length == 0)) {
            return 0;
        }
        
        int max = 0;
        
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[i].length ; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max , fun(grid , i , j));
                }        
            }
        }
        return max;
    }
    
    public int fun(int grid[][] , int i , int j) {
        if((i < 0) || (i >= grid.length) || (j < 0) || (j >= grid[i].length) || (grid[i][j] == 0)) {
            return 0;
        }
        
        grid[i][j] = 0;
        
        int c = 1;
        
        c += fun(grid , (i + 1) , j);
        c += fun(grid , (i - 1) , j);
        c += fun(grid , i , (j + 1));
        c += fun(grid , i , (j - 1));
        
        return c;
    }
}
