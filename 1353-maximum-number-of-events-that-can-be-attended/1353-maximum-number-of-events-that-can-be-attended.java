class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b)->a[0]-b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int idx = 0, day = 1, cnt =0; 

        while(idx<events.length || !pq.isEmpty()){
            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }
            while(idx<events.length && events[idx][0]<=day){
                pq.offer(events[idx++][1]);
            }

            if(!pq.isEmpty()){
                pq.poll();
                cnt++;
            }
            day++;
            //System.out.println("day " + day);
        }
        return cnt;
    }
}