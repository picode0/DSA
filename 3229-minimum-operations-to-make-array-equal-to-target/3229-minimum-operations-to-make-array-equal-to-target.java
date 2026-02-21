class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        // 1 1 1 2 
        // 1 -2 2 

        // 3 0 0 -2
        
        long pre = 0, ret = 0;;
        for(int i=0;i<nums.length;i++){
            int diff = target[i] - nums[i];
            ret += Math.max(0, diff - pre);
            pre = diff; 
        }
        if(pre<0)
            ret-=pre;
        return ret; 
    }
}