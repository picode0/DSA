class Solution {
    Map<Integer,Integer> points = new HashMap<>();
    Map<Integer,Integer> cache = new HashMap<>();
    public int deleteAndEarn(int[] nums) {
        
        int maxNum = 0; 

        for(int num: nums){
            points.put(num ,points.getOrDefault(num, 0)+num);
            maxNum = Math.max(maxNum, num);
        }

        return helper(maxNum);

        /*
        int[] dp = new int[maxNum+1];
        dp[1] = points.getOrDefault(1, 0);
       
        for(int i=2;i<=maxNum;i++){
            dp[i] = Math.max(dp[i-2] + points.getOrDefault(i, 0), dp[i-1]);
        }
        return dp[maxNum];
        */
        /*
        int prevprev = 0;
        int prev = points.getOrDefault(1, 0);
        int curr = prev;

        for(int i=2;i<=maxNum;i++){
            curr = Math.max(prev, prevprev + points.getOrDefault(i, 0));
            prevprev = prev;
            prev = curr;
        }
        return curr;
        */
    }

    public int helper(int num){
        if(num==0)
            return 0;
        if(num==1)
            return points.getOrDefault(1,0);
        
        if(cache.containsKey(num))
            return cache.get(num);

        int ret = Math.max(helper(num-1), helper(num-2) + points.getOrDefault(num, 0));

        cache.put(num, ret);
        return ret;
    }
}