class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        //int[] prefix = new int[nums.length];
        //prefix[0] = nums[0];

        int total = 0;
        for(int num: nums)
            total+=num;

        // 2 3 5
        // 2 5 10

        int[] ret = new int[nums.length];
        int leftSum = 0; 
        for(int i=0;i<nums.length;i++){
            
            int rightSum = total - leftSum - nums[i];


            int leftDiff = nums[i]*i - leftSum;
            int rightDiff = rightSum - nums[i]*(nums.length-i-1);
            ret[i] = leftDiff + rightDiff;
            leftSum+=nums[i];
        }
        return ret;

    }
}