class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long pre = 1;
        long ret = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                ret+= (pre*(pre+1)/2);
                pre = 1;
            }
            else    
                pre++;
        }
        ret+= (pre*(pre+1))/2;
        return ret; 
    }
}