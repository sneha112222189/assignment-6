import java.util.*;

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] x : dp) Arrays.fill(x,Integer.MAX_VALUE);
        int sum = Integer.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
            sum = Math.min(sum,min(grid,0,i,dp));
        }
        return sum;
    }

    int min(int[][] grid,int i,int j,int[][] dp){
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length) return Integer.MAX_VALUE;

        if(i==grid.length-1) return grid[i][j];

        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int sum1 = Integer.MAX_VALUE;
        for(int k=0;k<grid.length;k++){
            if(j==k) continue;
            sum1 = Math.min(sum1,min(grid,i+1,k,dp));
        }

        dp[i][j] = grid[i][j] + sum1;
        return dp[i][j];
    }
}
