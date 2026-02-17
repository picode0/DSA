class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int num:nums)
            sum+=num;
        
        if(sum%2==1)
            return false;

        int target = sum/2;


        Boolean[][] memo = new Boolean[nums.length+1][target+1];

        return dfs(nums, nums.length-1, target, memo);
        /*
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
        */
    }

    public Boolean dfs(int[] nums, int n, int target, Boolean[][] memo){
        if(target==0)
            return true;
        
        if(n==0 || target <0)
            return false;
        
        if(memo[n][target]!=null)
            return memo[n][target];

        memo[n][target] = dfs(nums, n-1, target,memo) || dfs(nums, n-1, target-nums[n-1], memo); 

        return memo[n][target];
        
    } 


}