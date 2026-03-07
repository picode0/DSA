class Solution {
    public int countWays(List<Integer> nums) {
        // 0 2 3 3 6 6 7 7 
        Collections.sort(nums);

        int currSize = 1;
        int ret = nums.get(0)==0?0:1;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)>currSize && currSize > nums.get(i-1))
                ret++;
            currSize++;
        }
        return currSize > nums.get(nums.size()-1)?ret+1:ret;
    }
}