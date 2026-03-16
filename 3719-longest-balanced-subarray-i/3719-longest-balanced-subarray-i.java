class Solution {
    public int longestBalanced(int[] nums) {
        int ret = 0;
        for(int i=0;i<nums.length;i++){
            Set<Integer> evenCount = new HashSet<>();
            Set<Integer> oddCount = new HashSet<>();
            for(int j=i;j<nums.length;j++){
                if(nums[j]%2==0)
                    evenCount.add(nums[j]);
                else
                    oddCount.add(nums[j]);

                if(evenCount.size() == oddCount.size())
                    ret = Math.max(ret, j-i+1);
            }
        }
        return ret;
    }
}