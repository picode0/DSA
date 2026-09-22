class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] left = new long[n];
        Stack<Integer> stack = new Stack<>();

        long ret = 0, curr = 0;

        stack.push(-1);
        for(int i=0;i<n;i++){
            while(stack.size()>1 && maxHeights.get(stack.peek()) > maxHeights.get(i)){
                int j = stack.pop();
                curr -= (long) (j-stack.peek())*maxHeights.get(j);
            }
            curr+= (long)maxHeights.get(i) * (i-stack.peek());
            stack.push(i);
            left[i] = curr;
        }
        stack.clear();
        stack.push(n);
        curr = 0;
        for(int i=n-1;i>=0;i--){
            while(stack.size()>1 && maxHeights.get(stack.peek()) > maxHeights.get(i)){
                int j = stack.pop();
                curr-=(long) (stack.peek() - j) *maxHeights.get(j);
            }
            curr+= (long)(stack.peek() - i)*maxHeights.get(i);
            stack.push(i);
            ret = Math.max(ret, left[i] + curr - maxHeights.get(i));
        }
        return ret;
    }
}