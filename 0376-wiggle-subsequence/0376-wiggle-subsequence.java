class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length==1)
            return 1;

        dp[0] = 1;
        //dp[1] = nums[1]==nums[0] ? 1:2;
        int multiplier = 0;

        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                dp[i] = dp[i-1];
                continue;
            }

            int diff = nums[i] - nums[i-1];
            if(multiplier==0){
                multiplier = diff>0?1:-1;
                dp[i] = 2;
            }
            else{
                if(diff*multiplier < 0){
                    dp[i] = dp[i-1]+1;
                    multiplier*=-1;
                }
                else{
                    dp[i] = dp[i-1];
                }
                
            }
        }

        return dp[dp.length-1];

    }
}