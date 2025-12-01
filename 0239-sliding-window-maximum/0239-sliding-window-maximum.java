class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 1 3 -1 -3 5 3 6 7
        // 1 2 

        // 3, 3, 1, 5
        Deque<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>(); 

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
    }
}