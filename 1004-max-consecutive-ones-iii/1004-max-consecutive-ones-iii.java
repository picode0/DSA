class Solution {
    public int longestOnes(int[] nums, int k) {
        int kcount = k;
        int maxConsOnes = 0;
        int left = 0;
        int ret =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1 || --kcount >=0){
                maxConsOnes++;
            }
            else{
                while(kcount <0){
                    if(nums[left++] ==0){
                        kcount++;
                    }
                    else
                        maxConsOnes--;
                }
            }
            ret = Math.max(ret, maxConsOnes);
        }
        return ret; 
    }
}