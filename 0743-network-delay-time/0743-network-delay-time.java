class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> map = new HashMap<>();

        for(int[] time: times){
            List<int[]> list = map.getOrDefault(time[0], new ArrayList<>());
            list.add(new int[]{time[2], time[1]});
            map.put(time[0], list);
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            if(poll[0] > dist[poll[1]]){
                continue;
            }
            //System.out.println(poll[1]);
            List<int[]> adjList = map.getOrDefault(poll[1], new ArrayList<>());
            for(int[] adj: adjList){
                if(dist[poll[1]] + adj[0] < dist[adj[1]]){
                    dist[adj[1]] = dist[poll[1]] + adj[0];
                    pq.offer(new int[]{dist[adj[1]], adj[1]});
                }
            }
        }

        int ret = 0;
        for(int i=1;i<dist.length;i++){
            //System.out.println(" i " + i + " dist " + dist[i]);
            if(dist[i]==Integer.MAX_VALUE)
                return -1;
            ret = Math.max(ret, dist[i]);
        }
        return ret; 
        // 1-> (1, 2)
        // 2-> (3, 1)
        // dist -> {4, 3,0}
    }
}