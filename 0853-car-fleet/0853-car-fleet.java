class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // 0 3 5 8 10
        // 1 3 1 4 2 
        // 12 3 7 1 1
        // 12 3 

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0] - b[0]);

        for(int i=0;i<position.length;i++){
            pq.add(new int[]{position[i], speed[i]});
        }

        Stack<Double> stack = new Stack<>();

        int[] starting = pq.poll();
        stack.add((double)(target - starting[0]) / starting[1]);

        while(!pq.isEmpty()){
            int[] posAndSpeed = pq.poll();
            double timeTaken = (double)(target-posAndSpeed[0])/posAndSpeed[1];
            while(!stack.isEmpty() && stack.peek() <= timeTaken)
                stack.pop();
            
            stack.push(timeTaken);
        }
        return stack.size();
    }
}