class Solution {
    int[][] memo;
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();

        memo = new int[m+1][n+1];
        for(int[] row : memo)
            Arrays.fill(row, -1);

        return solve(s,t,0,0);

    }

    public int solve(String s, String t, int sidx, int tidx){
        if(tidx == t.length())
            return 1;

        if(sidx == s.length())
            return 0;

        if(memo[sidx][tidx]!=-1)
            return memo[sidx][tidx];

        int notTake = solve(s,t,sidx+1, tidx);
        int take = 0;
        if(s.charAt(sidx) == t.charAt(tidx))
            take = solve(s,t,sidx+1, tidx+1);

        memo[sidx][tidx] = take + notTake;
        return take + notTake; 


    }
}