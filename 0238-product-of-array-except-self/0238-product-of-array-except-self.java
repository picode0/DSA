class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 1  1   2  6
        // 24 12  4  1
        //  
        int[] leftP = new int[nums.length];
        int[] rightP = new int[nums.length];

        leftP[0] = 1; 
        rightP[nums.length-1] = 1;

        for(int i=1;i<nums.length;i++){
            leftP[i] = leftP[i-1]*nums[i-1];
        }

        for(int i=nums.length-2;i>=0;i--){
            rightP[i] = rightP[i+1]*nums[i+1];
        }

        int[] ret = new int[nums.length];

        for(int i=0;i<ret.length;i++)
            ret[i] = rightP[i] * leftP[i];

        return ret;
    }
}