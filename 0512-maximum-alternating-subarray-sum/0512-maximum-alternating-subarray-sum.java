class Solution {
    public long maximumAlternatingSubarraySum(int[] nums) {
        long evensum = nums[0], oddsum = 0;
        long retval = nums[0];

        for(int i=1;i<nums.length;i++){
            if(i%2==0){
                evensum = Math.max(nums[i], nums[i]+evensum);
                oddsum -= nums[i];
            }
            else{
                oddsum = Math.max(nums[i], nums[i]+oddsum);
                evensum -= nums[i];
            }
            retval = Math.max(retval, Math.max(evensum, oddsum));
        }
        return retval;



    }
}