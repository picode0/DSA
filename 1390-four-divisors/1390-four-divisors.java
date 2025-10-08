class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum =0 ;
        for(int i=0;i<nums.length;i++){
            int divisorsSum = 0, cnt = 0;
            for(int j=1;j*j<=nums[i];j++){
                if(nums[i] % j==0){
                    if(j*j == nums[i]){
                        cnt ++;
                        divisorsSum += j;
                    }
                    else{
                        cnt+=2;
                        divisorsSum += ( j+ nums[i]/j);
                    }
                }
            }
            if(cnt==4)
                sum+=divisorsSum;
        }
        return sum;
    }
}