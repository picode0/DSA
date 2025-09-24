class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>(); 


        int curr = 0;
        for(int num:nums)
            set.add(num);

        int total = set.size(); 
    
        int right = 0 ;
        int ret = 0;
        for(int left=0;left<nums.length;left++){
            if(left>0){
                map.put(nums[left-1], map.get(nums[left-1])-1);
                if(map.get(nums[left-1])==0)
                    map.remove(nums[left-1]);
            }
            while(right<nums.length && map.size() < total){
                map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
                right++;
            }
            if(map.size() == total)
                ret+= nums.length - right +1;

        }
        return ret;
    }
}