class Solution {
    public int trap(int[] height) {

        int left = 0, right = height.length-1;
        int leftmax = 0, rightmax = 0;
        int ret = 0;
        while(left<right){
            if(height[left] <= height[right]){
                leftmax = Math.max(leftmax, height[left]);
                ret += leftmax - height[left++];
            }else{
                rightmax = Math.max(rightmax, height[right]);
                ret+= rightmax - height[right--];
            }
        }

        return ret;
        /*
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
        */
        // 0
        // 
    }
}