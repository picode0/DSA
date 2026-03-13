class Solution {
    public int minLength(int[] nums, int k) {
       // 10 4 14 22 23

        int sum = 0;
        int left = 0;
        int ret = nums.length+1;
        Map<Integer,Integer> map = new HashMap<>();

        //System.out.println(right);
        for(int right = 0;right<nums.length;right++){
            if(nums[right]>=k) return 1;

            if(!map.containsKey(nums[right])){
                map.put(nums[right],1);
                sum+=nums[right];
            }
            else{
                map.put(nums[right], map.get(nums[right])+1);
            }
            //System.out.println("r " + i + " left " + left);
            while(sum>=k){
                ret = Math.min(ret, right-left+1);
                //System.out.println(" ret " + ret + " left right " + left + " " + i);
                if(map.get(nums[left])>1){
                    map.put(nums[left], map.get(nums[left])-1);
                }
                else{
                    sum-=nums[left];
                    map.remove(nums[left]);      
                }
                left++;
            }
            //System.out.println(" ret " + ret);
        }
        return ret==nums.length+1?-1:ret;
    }
}