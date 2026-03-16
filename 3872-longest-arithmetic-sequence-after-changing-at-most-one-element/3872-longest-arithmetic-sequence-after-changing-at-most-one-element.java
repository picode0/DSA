class Solution {
    public int longestArithmetic(int[] nums) {
        
        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length]; 

        leftMax[0] = 1;
        leftMax[1] = 2;
        rightMax[nums.length-1] = 1;
        rightMax[nums.length-2] = 2;

        for(int i=1;i<nums.length-1;i++){
            leftMax[i+1] = nums[i] - nums[i-1] == nums[i+1]-nums[i]?leftMax[i]+1:2;
        }

        for(int i=nums.length-2;i>=1;i--){
            rightMax[i-1] = nums[i] - nums[i+1] == nums[i-1] - nums[i]?rightMax[i]+1:2;
        }
        int ret =0;
        for(int i=0;i<nums.length;i++){
            ret = Math.max(ret, Math.max(leftMax[i], rightMax[i]));
            if(i==0){
                ret = Math.max(ret, rightMax[i+1]+1);
            }
            else if(i==nums.length-1){
                ret = Math.max(ret, leftMax[i-1]+1);
            }
            else{
                int leftSideMax = leftMax[i-1] +1;
                int rightSideMax = rightMax[i+1] + 1;
                ret = Math.max(ret, Math.max(leftSideMax, rightSideMax));
                if((nums[i+1] - nums[i-1]) % 2==0){
    
                    int reqDiff = (nums[i+1] - nums[i-1]) / 2;
                    int leftLen = 1, rightLen = 1;
                    if(i>=2 && nums[i-1] - nums[i-2] ==reqDiff)
                        leftLen = leftMax[i-1];
                    if(i<=nums.length-3 && nums[i+2] - nums[i+1] == reqDiff)
                        rightLen = rightMax[i+1];
                    
                    int mergedLen = 1 + leftLen + rightLen;
                    ret = Math.max(ret, mergedLen);
                }
            }
        }
        return ret;
    }
}