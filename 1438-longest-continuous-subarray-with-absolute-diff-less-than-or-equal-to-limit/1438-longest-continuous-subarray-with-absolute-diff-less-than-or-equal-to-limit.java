class Solution {
    public int longestSubarray(int[] nums, int limit) {
        //8  
        //8
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();

        int left=0, ret=0;

        for(int right=0;right<nums.length;right++){
            while(!maxQueue.isEmpty() && maxQueue.peekLast() < nums[right]){
                maxQueue.pollLast();
            }
        
            while(!minQueue.isEmpty() && minQueue.peekLast() > nums[right]){
                minQueue.pollLast();
            }
            maxQueue.addLast(nums[right]);
            minQueue.addLast(nums[right]);

            while(maxQueue.peekFirst() - minQueue.peekFirst() > limit){
                if(maxQueue.peekFirst() == nums[left])
                    maxQueue.removeFirst();
                if(minQueue.peekFirst() == nums[left++])
                    minQueue.removeFirst();
                
            }
            ret = Math.max(ret, right-left+1);

        }
        return ret;
    }
}