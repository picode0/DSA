class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] minPrefix = new long[k];

        Arrays.fill(minPrefix, Long.MAX_VALUE/2);
        minPrefix[k-1] = 0;
        long sum = 0, ret = Long.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int pos = i%k;
            ret = Math.max(ret, sum - minPrefix[pos]);
            minPrefix[pos] = Math.min(minPrefix[pos], sum);
        }

        return ret;


    }
}