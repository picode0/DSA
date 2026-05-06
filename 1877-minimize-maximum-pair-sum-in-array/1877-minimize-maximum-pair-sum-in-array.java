class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        int left = 0, right= nums.length-1;

        while(left<right){
            ret = Math.max(ret, nums[right--]+nums[left++]);
        }
        return ret; 
       
    }
}