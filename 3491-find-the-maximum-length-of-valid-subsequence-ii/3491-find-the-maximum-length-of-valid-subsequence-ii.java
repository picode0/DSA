class Solution {
    public int maximumLength(int[] nums, int k) {
        // 1 1 2 0 1 1 
        // 1 0 1 0 1
        int[][] dp = new int[k][k]; 
        int ret = 0;
        for(int num:nums){
            int n = num%k;
            for(int i=0;i<k;i++){
                dp[i][n] = dp[n][i]+1;
                ret = Math.max(ret, dp[i][n]);
            }
        }
        return ret; 
    }
}