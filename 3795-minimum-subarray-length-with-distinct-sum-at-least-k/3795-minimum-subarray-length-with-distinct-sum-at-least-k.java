class Solution {
    public int minLength(int[] nums, int k) {

        int sum = 0, left =0;
        int ret = nums.length+1;
        Map<Integer,Integer> map = new HashMap<>();

        for(int right = 0;right<nums.length;right++){
            if(nums[right]>=k) return 1;
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            if(map.get(nums[right])==1){

                sum+=nums[right];
            }
         
            while(sum>=k){
                ret = Math.min(ret, right-left+1);
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    sum-=nums[left];
                }
                left++;
            }
        }
        return ret==nums.length+1?-1:ret;
    }
}