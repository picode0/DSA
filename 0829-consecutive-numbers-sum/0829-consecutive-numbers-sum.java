class Solution {
    public int consecutiveNumbersSum(int n) {
        //   x+k-3 x+k-2 x+k-1
        // kx + k(k-1)/x = n 
        /// kx = n - k(k-1)/2
        // n>k(k-1)/2 
        // 2n > k(k-1) 
        // n > (K*k -k) / 2

        int ans = 0; 

        for(int k=1; 2*n > k*(k-1);k++){
            if((n - k*(k-1)/2)%k ==0)
                ans++; 
        }
        return ans;
    }
}