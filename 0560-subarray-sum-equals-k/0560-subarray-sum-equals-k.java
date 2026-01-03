class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, ret = 0;

        Map<Integer, Integer> prefixSums = new HashMap<>();

        prefixSums.put(0, 1);

        for(int num: nums){
            sum+=num;

            if(prefixSums.containsKey(sum-k)){
               ret+=prefixSums.get(sum-k); 
            }

            prefixSums.put(sum, prefixSums.getOrDefault(sum, 0)+1);
        }
        return ret; 
    }
   
}