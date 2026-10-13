class Solution {
    public int numDistinct(String s, String t) {
        // rabbbit  rabbit 
        // dp[0][0] = 1 dp[1][1] = 0 + 1 dp[1][2] =0 ... dp[1][7] = 0;
        // dp[2][1] = 1 dp[2][2] = 1 + 1
        // 
        int m = s.length(), n = t.length();

        int[] dp = new int[n+1];

        dp[0] = 1;

        for(int i=1;i<=m;i++){
            for(int j=n;j>=1;j--){
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[j] += dp[j-1];
            }
        }

        return dp[n];

    }
}