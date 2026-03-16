class Solution {
    public boolean find132pattern(int[] nums) {
        int[] minNum = new int[nums.length];
        minNum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            minNum[i] = Math.min(minNum[i-1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i] > minNum[i]){
                while(!stack.isEmpty() && stack.peek() <= minNum[i]){
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() < nums[i]) return true;
                stack.push(nums[i]);
            }
        }
        return false;
    }
}