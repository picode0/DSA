class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        // x0011x
        long[] prefixProfit = new long[prices.length+1];
        long[] prefixPrice = new long[prices.length+1];
        
        for(int i=1;i<prefixProfit.length;i++){
            prefixProfit[i] = prefixProfit[i-1] + (long)prices[i-1]*strategy[i-1];
            prefixPrice[i] = prefixPrice[i-1] + (long)prices[i-1];
        }

        // * 4 2 8
        // 0 4 6 14 
        // 0 -4 -4 4

        // * 5 4 3
        // 0 5 9 12
        // 0 5 9 9
        long ret = prefixProfit[prices.length];
        for(int i=0;i<prices.length-k+1;i++){
            long prev = prefixProfit[i];
            long curr = prefixPrice[i+k] - prefixPrice[i+k/2];
            long next = prefixProfit[prefixProfit.length-1] - prefixProfit[i+k];
            ret = Math.max(ret, prev+curr+next);
        }
        return ret;
    }
}