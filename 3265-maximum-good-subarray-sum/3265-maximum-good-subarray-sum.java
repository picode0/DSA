class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Long> map = new HashMap<>();

        long curr = 0;
        long ret = Long.MIN_VALUE;
        for(int num: nums){
            if(map.containsKey(num - k)){
                long pre = map.get(num-k);
                ret = Math.max(ret, curr+num-pre);
            }
            if(map.containsKey(num+k)){
                long pre = map.get(num+k);
                ret = Math.max(ret, curr+num-pre);
            }
            map.put(num, Math.min(map.getOrDefault(num, Long.MAX_VALUE), curr));
            curr+=num;
        }
        return ret==Long.MIN_VALUE?0:ret;
    }
}