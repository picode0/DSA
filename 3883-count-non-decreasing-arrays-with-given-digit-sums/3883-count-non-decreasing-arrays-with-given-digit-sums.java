class Solution {
    int[][] memo;
    int mod = 1000000007;
    public int countArrays(int[] digitSum) {
        int n = digitSum.length;
        memo = new int[n+1][5002];
        for(int[] arr: memo)
            Arrays.fill(arr,-1);
        
        return solve(0,0,digitSum);
        // solve(0,2)
        // [1, 2] [10,11] [1,11] 
        
    }

    public int solve(int idx, int num, int[] digitSum){
        if(idx==digitSum.length)
            return 1;
        if(num>5000) 
            return 0;

        if(memo[idx][num]!=-1)
            return memo[idx][num];
        int ret = 0;
        if(check(num, digitSum[idx])){
            ret = ret + solve(idx+1, num, digitSum) % mod;
        }
        ret = ret + solve(idx, num+1, digitSum) % mod;

        memo[idx][num] = ret;

        return ret;
    }

    public boolean check(int num, int sum){
        int curr = 0;
        while(num>0){
            int last = num%10;
            curr+=last;
            num/=10;
        }
        return curr == sum;
    }
}