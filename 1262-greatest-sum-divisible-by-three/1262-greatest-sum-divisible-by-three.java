class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for(int num: nums){
            int[] curr = dp.clone();
            for(int bestSum : curr){
                int newSum = bestSum + num;
                int remainder = newSum % 3;
                dp[remainder] = Math.max(dp[remainder], newSum);
            }
        }
        return dp[0];
    }
}