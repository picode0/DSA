class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        // 6 + x + y = 11 + z 
        // 5 = x + y - z

        // 6 0 0
        // 11 0

        long sum1 = 0, numzero1 = 0, sum2 = 0, numzero2 = 0;
        for(int num: nums1){
            if(num==0){
                numzero1++;
                sum1++;
            }
            sum1+=num;
        }

        for(int num: nums2){
            if(num==0){
                numzero2++;
                sum2++;
            }
            sum2+=num;
        }
        
        if((sum1<sum2 && numzero1 ==0)  || (sum2<sum1 && numzero2==0))
            return -1;

        return Math.max(sum1,sum2);
        
    }
}