class Solution {
    public int minimizeArrayValue(int[] nums) {
        long prefix = 0, ret=0;
        for(int i=0;i<nums.length;i++){
            prefix+=nums[i];
            ret = Math.max(ret, (prefix+i)/(i+1));
        }
        return (int)ret; 
        /*
        long maxNum = 0;

        for(int num:nums)
            maxNum = Math.max(maxNum, num);

        long left =0, right = maxNum;

        while(left<right){
            long mid = left + (right-left)/2;

            if(withinLimit(nums, mid)){
                right = mid;
            }
            else{
                left = mid +1;
            }
        }
        return (int)left;
        */


    }

    public boolean withinLimit(int[] nums, long limit){

        //int[] temp = nums.clone();
        long overflow = 0;
        for(int i=nums.length-1;i>0;i--){
            long val = nums[i] + overflow;
            overflow = val>limit?val - limit:0;
        }

        return nums[0]+overflow<=limit;
    }


}