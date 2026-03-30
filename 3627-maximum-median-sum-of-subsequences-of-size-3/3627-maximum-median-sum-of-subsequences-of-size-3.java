class Solution {
    public long maximumMedianSum(int[] nums) {
        // 2 1 3 2 1 3 
        // 1 1 2 2 3 3
        Arrays.sort(nums); 

        long ret = 0;
        int left = 0, right = nums.length-1;

        while(left<right){
            ret+=nums[right-1];
            left++;
            right-=2;
        } 
        return ret;
    }
}