class Solution {
    public int maximumLength(int[] nums) {
        int even = 0, odd = 0, alternating = 1; 

        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0)
                even++;
            else
                odd++;
            
            if(i>0){
                if(nums[i]%2 != nums[i-1]%2)
                    alternating ++;
            }
        }
        return Math.max(Math.max(even,odd), alternating);

    }
}