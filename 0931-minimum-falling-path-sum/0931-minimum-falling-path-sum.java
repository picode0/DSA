class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length+1][matrix[0].length];
        //Arrays.fill(dp, Integer.MAX_VALUE);
        int ret = Integer.MAX_VALUE;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = Integer.MAX_VALUE;
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + matrix[i-1][j]);
                if(j-1 >=0)
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + matrix[i-1][j]);

                if(j+1 < dp[0].length)
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1] + matrix[i-1][j]);

                if(i==dp.length-1)
                    ret = Math.min(ret, dp[i][j]);
            }
        }
        return ret;
    }
}