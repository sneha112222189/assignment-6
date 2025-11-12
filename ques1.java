import java.util.*;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] x : dp){
            Arrays.fill(x,-1);
        }
        return path(obstacleGrid,0,0,dp);
    }

    int path(int[][] grid,int i,int j,int[][] dp){
        if(i>=grid.length || j>=grid[i].length) return 0;

        if(i==grid.length-1 && j==grid[i].length-1 && grid[i][j] != 1) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(grid[i][j] == 0){
            dp[i][j]=path(grid,i,j+1,dp)+path(grid,i+1,j,dp);
        }
        else{
            return 0;
        }
        return dp[i][j];
    }
}