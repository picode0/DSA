class Solution {
    public int countNicePairs(int[] nums) {
        int mod = (int)1e9 +7;
        // nums[i] - rev(nums[i]) == nums[j]-rev(nums[j])
        int ret  =0 ;
        Map<Integer,Integer> map = new HashMap<>(); 
        for(int num:nums){
            int target = num - reverse(num);
            if(map.containsKey(target))
                ret= (ret + map.get(target))%mod;
            map.put(target, map.getOrDefault(target, 0)+1);
        }
        return ret; 
    }
    public int reverse(int num){
        int ret = 0;
        while(num>0){
            ret = ret*10 + (num%10);
            num/=10;
        }
        return ret; 
    }
}