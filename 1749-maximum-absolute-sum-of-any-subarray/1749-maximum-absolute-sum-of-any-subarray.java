class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        int posCurr = 0;
        int negCurr = 0;
        int maxSum = 0;
        int minSum = Integer.MAX_VALUE;

        for(int num: nums){
            posCurr = Math.max(posCurr+num, num);
            negCurr = Math.min(negCurr+num, num); 
            maxSum = Math.max(maxSum, posCurr);
            minSum = Math.min(minSum, negCurr);
        }  

        return Math.max(maxSum, -minSum);
    }
}