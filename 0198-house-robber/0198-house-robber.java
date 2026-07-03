class Solution {
    //int[] memo;
    public int rob(int[] nums) {

        if(nums.length<2)
            return nums[0];

        int robPrevPrev = 0;
        int robPrev = nums[0];
        int curr = 0;
        for(int i=1;i<nums.length;i++){
            curr = Math.max(robPrev, robPrevPrev + nums[i]);
            robPrevPrev = robPrev;
            robPrev = curr;
        }
        return curr;
        /*
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dphelper(nums, 0);
        */
        /*
        if(nums.length<2)
            return nums[0];
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);


        for(int i=2;i<dp.length;i++)
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
 
        return dp[dp.length-1];
        */
    }
    /*
    public int dphelper(int[] nums, int idx){
        if(idx>=nums.length)
            return 0;

        if(memo[idx]!=-1)
            return memo[idx];

        int ret = Math.max(dphelper(nums, idx+1), dphelper(nums, idx+2)+nums[idx]);
        memo[idx] = ret;

        return ret;
    }
    */
}