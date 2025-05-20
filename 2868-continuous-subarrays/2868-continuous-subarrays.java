class Solution {
    public long continuousSubarrays(int[] nums) {
        int left = 0;
        long ret = 0;
        int minval=nums[0], maxval = nums[0]; 
        long currlen;
        for(int right = 0;right<nums.length;right++){
            minval = Math.min(minval, nums[right]);
            maxval = Math.max(maxval, nums[right]);
            if(maxval - minval <=2 )
                continue; 
            
            currlen = right - left; 
            ret += currlen*(currlen+1)/2;

            left = right; 
            int tempmaxval = Math.max(nums[left-1], nums[right]); 
            int tempminval = Math.min(nums[left-1], nums[right]); 
            
            while(left>0 && tempmaxval-tempminval <=2){
                left--; 
                maxval = tempmaxval;
                minval = tempminval;
                if(left>0){
                    tempmaxval = Math.max(nums[left-1], tempmaxval); 
                    tempminval = Math.min(nums[left-1], tempminval);  
                }
            }
            currlen = right - left;

            ret -= currlen*(currlen+1)/2;
        }
        currlen = nums.length - left;
        ret+= (currlen)*(currlen+1)/2;

        return ret;

    }
}