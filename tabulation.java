
/*
class Main {
    public static void main(String[] args) {
        int[] wt = {5,4,2,3};
        int[] val = {10,40,30,50};
        int w  = 5;
        int[][] dp = new int[wt.length][w+1];
        for(int[] x : dp) Arrays.fill(x,-1);
        System.out.println("\n"+max(w,val,wt,0,dp));
        for(int[] x : dp){
            System.out.println(Arrays.toString(x));
        }
    }
    
    static int max(int w,int[] val,int[] wt,int i,int[][] dp){
        if(i>wt.length-1) return 0;
        if(w<wt[i]) return max(w,val,wt,i+1,dp);
        
        if(dp[i][w] != -1) return dp[i][w];
        
        int sum1 = val[i]+max(w-wt[i],val,wt,i+1,dp);
        int sum2 = max(w,val,wt,i+1,dp);
        
        dp[i][w] = Math.max(sum1,sum2);
        
        return dp[i][w];   
     }
}*/

class Solution{
    public static void main(String []args){
        int[] wt = {2,4,3};
        int[] val = {10,40,40};
        int w  = 5;
        int[][] dp = new int[wt.length][w+1];
        System.out.println(tabulation(dp,wt,val,w));
    }
        static int tabulation(int[][] dp,int[] wt,int[] val,int w){
        
        int sum1=0,sum2=0;
        for(int i=0;i<=wt.length;i++){
            for(int j=0;j<=w;j++){
                if(j==0 || i==0) {
                    dp[i][j] = 0;
                    continue;
                }
                if(wt[i-1]<=j) sum1 = val[i-1]+dp[i-1][j-wt[i-1]];
                sum2 = dp[i-1][j];
                dp[i][j] = Math.max(sum1,sum2);
            }
        }
        return dp[wt.length][w];
    }
}
