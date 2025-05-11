class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int left=i+1, right = nums.length-1;
            int target = 0-nums[i];
            while(left<right){
                if(nums[left]+nums[right]==target){
                    list.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    while(left<right && nums[left]==nums[left-1])
                        left++;
                }
                else if(nums[left]+nums[right]>target)
                    right--;
                else   
                    left++;
            }
        }
        return list;
    }
}