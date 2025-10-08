class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ret = 0;
        // (1)1 (2)5 (3)6    (4)2
        for(int i=0;i<heights.length;i++){
            while(stack.peek()!=-1 && heights[stack.peek()] > heights[i]){
                
                int height = heights[stack.pop()];
                int width = i - stack.peek() -1;
                //System.out.println("i " + i +" height " + height + " width " + width + " peek " + stack.peek());
                ret = Math.max(ret, height*width);
            }
            stack.push(i);
        }
        while(stack.peek() != -1){
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() -1;
            ret = Math.max(ret, height*width);
        }

        return ret;

    }
}