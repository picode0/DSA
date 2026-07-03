class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        return Math.max(robFrom(nums, 0, nums.length-1), robFrom(nums, 1, nums.length));

    }

    public int robFrom(int[] nums, int start, int end){

        int robPrev = nums[start];
        int robPrevPrev = 0;
        int curr = nums[start];
        for(int i=start+1;i<end;i++){
            curr = Math.max(robPrev, robPrevPrev + nums[i]);
            robPrevPrev = robPrev;
            robPrev = curr;
        }
        return curr;
    }
}