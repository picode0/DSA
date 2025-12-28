class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        // dp[5][3] = 1, dp[5][2] = 1, dp[5][1] = 1
        // dp[4][3] = 1, dp[4][2] = 1, dp[4][1] = 1
        // ...

        for(String s: strs){
            int numOnes = 0, numZeroes = 0;
            for(char c : s.toCharArray()){
                if(c=='0')
                    numZeroes++;
                else
                    numOnes++;
            }

            for(int i=m;i>=numZeroes;i--){
                for(int j=n;j>=numOnes;j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i-numZeroes][j-numOnes]+1);
                }
            }
        }
        return dp[m][n];


    }
}