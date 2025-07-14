class Solution {
    public int maximumBeauty(int[] nums, int k) {
        //if(nums.length==1) return 1;
        int retval = 0;
        int maxnum = 0; 
        for(int num: nums)
            maxnum = Math.max(maxnum, num);

        int[] numcount = new int[maxnum+k+2]; 

        for(int num:nums){
            int lowidx = Math.max(0, num-k);
            int highidx =num+k+1;
            //System.out.println("low : " + lowidx + " high: " + highidx);
            numcount[lowidx]++;
            numcount[highidx]--;
        }

        int sum = 0;
        for(int val:numcount){
            sum+=val;
            retval = Math.max(retval, sum);
        }
        return retval;

        // 0 1 2  3 4 5 6
        // 2   1 -1 0  -2

        /*
        Arrays.sort(nums);
        int ret = 0; 
        int left = 0;
        for(int right=0;right<nums.length;right++){ 
            while(nums[right] - nums[left] > 2*k){
                left++;
            }
            ret = Math.max(ret, right-left+1);
        }
        return ret; 
        */

    }
}