class Solution {
    public int lengthOfLIS(int[] nums) {

        List<Integer> subset = new ArrayList<>();
        subset.add(nums[0]);

        for(int i=1;i<nums.length;i++){
            if(nums[i]>subset.get(subset.size()-1))
                subset.add(nums[i]);
            else{
                int idx = binarySearch(subset, nums[i]);
                subset.set(idx, nums[i]);
            }
        }
        return subset.size();
        /*
        int[] dp = new int[nums.length];
        int ret = 1;
        Arrays.fill(dp, 1);
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                ret = Math.max(ret, dp[i]);
            }
        }
        return ret;
        */
    }

    public int binarySearch(List<Integer> subset, int target){
        int left =0, right=subset.size()-1;

        while(left<right){
            int mid = left + (right-left)/2;
            if(subset.get(mid) < target)
                left = mid+1;
            else
                right  = mid;
        }
        return left;
    }
}