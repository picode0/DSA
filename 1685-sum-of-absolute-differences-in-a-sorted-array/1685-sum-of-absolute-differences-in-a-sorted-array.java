class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1;i<nums.length;i++)
            prefix[i] = prefix[i-1]+nums[i];

        // 2 3 5
        // 2 5 10

        int[] ret = new int[nums.length]; 
        for(int i=0;i<nums.length;i++){
            int leftSum = prefix[i] - nums[i];
            int rightSum = prefix[prefix.length-1] - prefix[i];

            int leftDiff = nums[i]*i - leftSum;
            int rightDiff = rightSum - nums[i]*(nums.length-i-1);
            ret[i] = leftDiff + rightDiff;

        }
        return ret;

    }
}