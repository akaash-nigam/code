public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[m];
        dp[0] = grid[0][0];
        for (int i=1;i<m;i++){
            dp[i]=dp[i-1]+grid[i][0];
        }
        for (int j=1;j<n;j++){
            for (int i=0;i<m;i++){
                if (i!=0 && j!=0){
                    dp[i]=grid[i][j]+Math.min(dp[i-1],dp[i]);
                }else{
                    dp[i]=dp[i]+grid[i][j];
                }
                
            }
        }
        return dp[m-1];
    }
}