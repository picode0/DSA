class Solution {
    public int longestNiceSubarray(int[] nums) {
        int usedBits = 0;
        int ret = 0;

        int left =0;

        for(int right =0;right<nums.length;right++){
            while((usedBits & nums[right] )!=0){
                usedBits ^= nums[left++];
            }

            usedBits |= nums[right];
            ret = Math.max(ret, right-left+1);
        }
        return ret;
    }
}