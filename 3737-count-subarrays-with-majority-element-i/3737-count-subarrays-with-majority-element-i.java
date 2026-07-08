class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] prefix = new int[2*n+1];
       
        prefix[n] = 1;

        int cnt = n;
        int presum = 0;
        int ret = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                presum+=prefix[cnt];
                cnt++;
                prefix[cnt]++;
            }
            else{
                cnt--;
                presum-=prefix[cnt];
                prefix[cnt]++;
            }
            ret+=presum;
        }
        return ret;
        /*
        int ret = 0;
        for(int i=0;i<nums.length;i++){
            int cnt = 0;
            for(int j=i;j<nums.length;j++){
                if(nums[j]==target){
                    cnt++;
                }
                if(cnt>(j-i+1)/2)
                    ret++;
            }
        }
        return ret; 
        */
    }
}