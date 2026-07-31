class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];

        dp[0] = 1;

        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j] += dp[j-coins[i]];
            }
        }
     
        return dp[amount];

        // 2,1,5

        // 0     1     2       3       4        5 
        // 1     1     2       2       3        3

        // ()         (2)             (2,2)

        //      (1)   (1,1)  (1,1,1) (1,1,1,1) (1,1,1,1,1)
        //                    (2,1)    (2,1,1)   (2,1,1,1)               
       //                                         (2,2,1)
       //                                           
    }
}