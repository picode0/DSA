class Solution {
    public int firstStableIndex(int[] nums, int k) {
        
        int[] maxArr = new int[nums.length];
        int[] minArr = new int[nums.length];
        int currmax = Integer.MIN_VALUE;
        int currmin = Integer.MAX_VALUE;
        for(int i=0;i<maxArr.length;i++){
            currmax = Math.max(currmax, nums[i]);
            maxArr[i] = currmax;
        }
        for(int i=minArr.length-1;i>=0;i--){
            currmin = Math.min(currmin, nums[i]);
            minArr[i] = Math.min(currmin, nums[i]);
        }

        for(int i=0;i<nums.length;i++){
            if(maxArr[i] - minArr[i] <= k)
                return i;
        } 

        return -1;
    }
}