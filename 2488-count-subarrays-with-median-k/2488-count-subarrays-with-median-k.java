class Solution {
    public int countSubarrays(int[] nums, int k) {
        
        // 2 5 1 4 3 6
        Map<Integer,Integer> prefixFreq = new HashMap<>();

        prefixFreq.put(0,1);
        int prefix = 0;
        boolean medianFound = false;
        int ret =0;
        for(int num:nums){
            if(num == k){
                medianFound = true;
            }
            else{
                prefix += num>k?1:-1;
            }

            if(medianFound){
                ret+=prefixFreq.getOrDefault(prefix, 0)+prefixFreq.getOrDefault(prefix-1, 0);
            }   
            else{
                prefixFreq.put(prefix, prefixFreq.getOrDefault(prefix, 0)+1);
            }
        }
        
        return ret;
    }
}