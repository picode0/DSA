class Solution {
    public int maximumBeauty(int[] nums, int k) {
        // 2 -  6
        //   4 - 8 
        //0-3 
        //0- 4

        // 1 2 4 6 
        Arrays.sort(nums);
        int ret = 0; 
        int left = 0;
        for(int right=0;right<nums.length;right++){ 
            while(nums[right] - nums[left] > 2*k){
                left++;
            }
            ret = Math.max(ret, right-left+1);
        }
        return ret; 

    }
}