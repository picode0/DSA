class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++)
            dp[i][0] = 1;

        for(int i=0;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i]>j)
                    dp[i+1][j] = dp[i][j];
                else
                    dp[i+1][j] = dp[i][j] + dp[i+1][j-coins[i]]; 
            }
        }

        return dp[coins.length][amount];
     


        // 1,1,1,1   2,1,1   2,2

        // [1,2]

        // 0 1 2 3
        // 1 0 0 0
    }
}