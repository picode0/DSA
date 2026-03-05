class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        // 9 21 51 70 k=2
        // 1 2 5 9 k=3
        
        int left =0;
   
        //int count =0;
        int maxlen = 0;
        for(int right=0;right<nums.length;right++){
            while( left<nums.length && (long)nums[left]*k < nums[right]){
                left++;
            }
            maxlen = Math.max(maxlen, right-left+1);

        }
        return nums.length - maxlen;
    }
}