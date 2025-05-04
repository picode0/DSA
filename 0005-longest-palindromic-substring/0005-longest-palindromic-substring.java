class Solution {
    public String longestPalindrome(String s) {
        
        int left=0, right=0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=1;i<s.length();i++){
            for(int j=0;j<i;j++){
                if(s.charAt(i)==s.charAt(j)&&(i-j<=2 || dp[j+1][i-1])){
                    dp[j][i]=true;
                    if(i-j>right-left){
                        left=j;
                        right=i;
                    }
                }
            }
        }
        return s.substring(left, right+1);
    }
}