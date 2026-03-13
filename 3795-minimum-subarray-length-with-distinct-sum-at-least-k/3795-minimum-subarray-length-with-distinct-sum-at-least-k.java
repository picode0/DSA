class Solution {
    public int minLength(int[] nums, int k) {

        int sum = 0, left =0;
        int ret = nums.length+1;
        Map<Integer,Integer> map = new HashMap<>();

        for(int right = 0;right<nums.length;right++){
            if(nums[right]>=k) return 1;

            if(!map.containsKey(nums[right])){
                map.put(nums[right],1);
                sum+=nums[right];
            }
            else{
                map.put(nums[right], map.get(nums[right])+1);
            }
         
            while(sum>=k){
                ret = Math.min(ret, right-left+1);
                if(map.get(nums[left])>1){
                    map.put(nums[left], map.get(nums[left])-1);
                }
                else{
                    sum-=nums[left];
                    map.remove(nums[left]);      
                }
                left++;
            }
        }
        return ret==nums.length+1?-1:ret;
    }
}