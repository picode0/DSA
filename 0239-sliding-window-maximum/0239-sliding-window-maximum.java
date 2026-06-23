class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 1 3 -1 -3 5 3 6 7
        // 1 2 

        // 3, 3, 1, 5
        Deque<Integer> queue = new LinkedList<>();
        int[] ret = new int[nums.length-k+1];
        int idx = 0;
        for(int i=0;i<nums.length;i++){
            if(!queue.isEmpty() && queue.peekFirst() == i-k)
                queue.pollFirst();
            
            while(!queue.isEmpty() && nums[queue.peekLast()]<nums[i])
                queue.pollLast();

            queue.offer(i);
            if(i>=k-1){
                ret[idx++] = nums[queue.peekFirst()];
            }
        } 
        return ret;




        /*
        for(int i=0;i<k;i++){
            while(!queue.isEmpty() && nums[i]>=nums[queue.peekLast()])
                queue.pollLast();
            queue.offerLast(i);
        }
        list.add(nums[queue.peekFirst()]);

        for(int i=k;i<nums.length;i++){
            if(queue.peek() == i - k  )
                queue.pollFirst();
            while(!queue.isEmpty() && nums[i] >= nums[queue.peekLast()])
                queue.pollLast();
            queue.offerLast(i);
            list.add(nums[queue.peekFirst()]);

        }

        return list.stream().mapToInt(i->i).toArray();
        */
    }
}