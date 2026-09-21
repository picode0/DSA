class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        int MOD = 1000000007;

        int[] lastPos = new int[26];
        int[] dp = new int[n+1];
        Arrays.fill(lastPos, -1);
        dp[0] = 1;
        for(int i=0;i<n;i++){
            char c = s.charAt(i); 
            dp[i+1] = dp[i]*2 % MOD;
            if(lastPos[c-'a'] >=0)
                dp[i+1] -= dp[lastPos[c-'a']];
            dp[i+1] %=MOD;
            lastPos[c-'a']=i;
        }

        dp[n]--;
        if(dp[n] <0)
            dp[n]+=MOD;
        return dp[n];
    
      
    }
}