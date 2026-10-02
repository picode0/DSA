class Solution {
    public boolean stoneGame(int[] piles) {
        // 5 3 4 5
        // dp[0][1] = 5 -3 = 2 //
        // dp[1][2] = 1
        // dp[2][3] = 1
        // dp[0][2] = 4
        // dp[1][3] = 4 
        // dp[0][3] = 1 
        int n = piles.length;
        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++)
            dp[i][i] = piles[i];
        
        for(int len = 2; len<=n;len++){
            for(int i=0;i+len-1<n;i++){
                int j = i + len -1;
                int takeLeft = piles[i] - dp[i+1][j];
                int takeRight = piles[j] - dp[i][j-1];
                dp[i][j] = Math.max(takeLeft, takeRight);
            }
        }
        return dp[0][n-1] >0;
    }
}