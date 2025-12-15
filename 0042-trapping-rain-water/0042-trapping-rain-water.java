class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ret = 0;
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int curr = stack.pop();
                if(stack.isEmpty()) break;
                int dis = i - stack.peek() -1;
                int ver = Math.min(height[i], height[stack.peek()]) - height[curr];
                ret+= dis*ver;
            }
            stack.push(i);
        }
        return ret; 
        // 0
        // 
    }
}