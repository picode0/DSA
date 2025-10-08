class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int ret = 0;
        int n= nums.length, m = pattern.length;
        for(int i=0;i<nums.length;i++){
            boolean match = true;
            if(i+m >=n)
                break;
            for(int j=i;j<i+m;j++){
                if(pattern[j-i]==-1 && nums[j+1] >= nums[j]){
                    match = false;
                    break;
                }
                if(pattern[j-i] == 0 && nums[j+1] != nums[j]){
                    match = false;
                    break;
                }
                if(pattern[j-i]==1 && nums[j+1] <=nums[j]){
                    match = false;
                    break;
                }
            }
            if(match)
                ret++;
        }
        return ret;
    }
}