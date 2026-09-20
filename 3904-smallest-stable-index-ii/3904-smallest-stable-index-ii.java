class Solution {
    public int firstStableIndex(int[] nums, int k) {
        
 
        int[] minArr = new int[nums.length];
        int currmin = Integer.MAX_VALUE;
        int currmax = Integer.MIN_VALUE;

        for(int i=minArr.length-1;i>=0;i--){
            currmin = Math.min(currmin, nums[i]);
            minArr[i] = Math.min(currmin, nums[i]);
        }

        for(int i=0;i<nums.length;i++){
            currmax = Math.max(currmax, nums[i]);
            if(currmax - minArr[i] <= k)
                return i;
        } 

        return -1;
    }
}