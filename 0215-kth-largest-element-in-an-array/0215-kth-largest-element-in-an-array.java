class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num: nums){ 
            pq.add(num);
            if(pq.size() > k)
                pq.poll();
        }


        return pq.peek();
        */

        // 0 1 2 3 4 5 
        //  
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;

        for(int num: nums){
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
        }

        int[] countSort = new int[maxNum - minNum +1];

        for(int num: nums){
            countSort[num-minNum]++;
        }

        int n = k;
        for(int i=countSort.length-1;i>=0;i--){
            n -= countSort[i];
            if(n<=0)
                return i+minNum;
        }
        return -1;

    }
}