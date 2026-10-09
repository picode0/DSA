class Solution {
    public int deleteAndEarn(int[] nums) {
        // 2 2 4 4 4 5 5
        // 4 0 12 10
        // 3 4 0 2

        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>(); 
        int sum = nums[0]; 
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1])
                sum+=nums[i];
            else{
                list.add(sum);
                sum = nums[i];
                if(nums[i]!=nums[i-1]+1)
                    list.add(0);
            }
        }

        list.add(sum);
        /*
        int[] memo = new int[list.size()];
        Arrays.fill(memo, -1);
        return dphelper(memo, list, 0);
        */
    
        if(list.size()==1)
            return list.get(0);

        //int[] dp = new int[list.size()];
        int prevprev = 0;
        int prev = list.get(0);
        int curr = 0;
        for(int i=1;i<list.size();i++){
            curr = Math.max(prev, prevprev + list.get(i));
            prevprev = prev;
            prev = curr;
        }
        return curr;
        /*
        dp[0] = list.get(0);
        dp[1] = Math.max(list.get(0), list.get(1));

        for(int i=2;i<list.size();i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+list.get(i));
        }
        return dp[list.size()-1];
        */
        

    }
    /*
    public int dphelper(int[] memo, List<Integer> list, int idx){
        if(idx>=list.size())
            return 0;
        if(memo[idx]!=-1)
            return memo[idx];

        int ret = Math.max(dphelper(memo, list, idx+1), dphelper(memo, list, idx+2)+list.get(idx));

        memo[idx] = ret;
        return ret;

    }
    */
}