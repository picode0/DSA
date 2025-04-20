class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int ret = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>=target){
                ret = Math.min(ret, i-left+1);
                sum-=nums[left++];
            }
        }
        return ret==Integer.MAX_VALUE?0:ret;
    }
}