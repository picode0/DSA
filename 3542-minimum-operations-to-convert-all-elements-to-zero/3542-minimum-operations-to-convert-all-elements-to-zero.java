class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int ret = 0;
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && stack.peek() > nums[i])
                stack.pop();
            if(nums[i]==0)
                continue;
            if(stack.isEmpty() || stack.peek() < nums[i] ){
                ret++;
                stack.push(nums[i]);
            }
        }
        return ret;
    }
}