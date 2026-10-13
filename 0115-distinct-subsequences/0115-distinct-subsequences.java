class Solution {
    public int numDistinct(String s, String t) {
        // rabbbit  rabbit 
        // dp[0][0] = 1 dp[1][1] = 0 + 1 dp[1][2] =0 ... dp[1][7] = 0;
        // dp[2][1] = 1 dp[2][2] = 1 + 1
        int m = s.length(), n = t.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++)
            dp[i][0] = 1;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = dp[i-1][j];
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] += dp[i-1][j-1];
            }
        }

        return dp[m][n];

    }
}