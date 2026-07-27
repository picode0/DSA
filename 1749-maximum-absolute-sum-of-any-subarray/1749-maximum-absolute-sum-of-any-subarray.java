class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        int curr = 0;
        int maxSum = 0;
        for(int num: nums){
            curr = Math.max(curr+num, num); 
            maxSum = Math.max(maxSum, curr);
        }   
        curr = 0;
        int minSum = Integer.MAX_VALUE;
        for(int num:nums){
            curr = Math.min(curr+num, num);
            minSum = Math.min(minSum, curr);
        }

        return Math.max(maxSum, -minSum);
    }
}