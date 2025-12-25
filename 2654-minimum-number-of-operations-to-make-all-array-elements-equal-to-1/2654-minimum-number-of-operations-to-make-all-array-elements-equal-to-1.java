class Solution {
    public int minOperations(int[] nums) {
        int numOnes = 0;
        int a = 0; 
        for(int num: nums){
            a = gcd(a, num);
            if(num==1)
                numOnes++;
        }

        if(a>1)
            return -1;
        if(numOnes>0)
            return nums.length - numOnes;
        
        int minLen = nums.length;
        for(int i=0;i<nums.length;i++){
            int currGcd = 0;
            for(int j= i;j<nums.length;j++){
                currGcd = gcd(currGcd, nums[j]);
                if(currGcd==1){
                    minLen = Math.min(minLen, j-i);
                    break;
                }
            }
        }

        return minLen+nums.length-1;



    }

    public int gcd(int a, int b){

        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }

        return a;
    }
}