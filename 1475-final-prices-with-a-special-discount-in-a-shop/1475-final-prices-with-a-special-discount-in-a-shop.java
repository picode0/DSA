class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<int[]> stack = new Stack<>();

        int[] ret = new int[prices.length];

        for(int i=0;i<prices.length;i++){
            while(!stack.isEmpty() && stack.peek()[0] >= prices[i]){
                int[] priceAndIdx = stack.pop();
                ret[priceAndIdx[1]] = priceAndIdx[0] - prices[i];
            }
            stack.push(new int[]{prices[i], i});
        }

        while(!stack.isEmpty()){
            int[] priceAndIdx = stack.pop();
            ret[priceAndIdx[1]] = priceAndIdx[0];
        }

        return ret;
    }
}