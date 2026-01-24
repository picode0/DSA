class Solution {
    public int countSubstrings(String s) {
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ret = 0;

        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j) && (i-j<=2 || dp[j+1][i-1])){
                    //System.out.println(" I " + i + " J " + j);
                    ret++;
                    dp[j][i] = true;
                }
            }
        }

        return ret; 
        // a a a a a 1 2 3 4 5
    }
}