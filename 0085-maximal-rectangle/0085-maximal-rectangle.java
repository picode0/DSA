class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] rowdp = new int[matrix[0].length];
        int ret = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                rowdp[j] = matrix[i][j]=='1'?rowdp[j]+1:0;
            }
            ret = Math.max(ret, maxarea(rowdp));
        }
        return ret;
    }

    public int maxarea(int[] ones){
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ret = 0;
        for(int i=0;i<ones.length;i++){
            while(stack.peek()!=-1 && ones[stack.peek()]>=ones[i]){
                int height = ones[stack.pop()];
                int width = i - stack.peek()-1;
                ret = Math.max(ret, height*width);
            }
            stack.push(i);
        }

        while(stack.peek()!=-1){
            int height = ones[stack.pop()];
            int width = ones.length-stack.peek()-1;
            ret = Math.max(ret, height*width);
        }
        return ret;
    }
}