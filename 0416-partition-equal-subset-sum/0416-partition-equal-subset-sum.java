class Solution {
    public boolean canPartition(int[] nums) {
        // 1 100 150 200 220
        // 1 2 5 



        int sum = 0;
        for(int num:nums)
            sum+=num;
        
        if(sum%2==1)
            return false;

        int target = sum/2;

        boolean[][] dp = new boolean[nums.length+1][target+1];
        dp[0][0] = true; 

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<=target;j++){
                if(nums[i] <= j){
                    dp[i+1][j] = dp[i][j] || dp[i][j-nums[i]];
                }
                else    
                    dp[i+1][j] = dp[i][j];
            }
        }
        return dp[nums.length][target];

    }
}