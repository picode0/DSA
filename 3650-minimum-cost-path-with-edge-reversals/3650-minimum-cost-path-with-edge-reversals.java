class Solution {
    public int minCost(int n, int[][] edges) {
        // <-------5-----
        // |             |
        // V             ^ 
        // 2 ---> 0 <----1

        //   21       12
        List<List<int[]>> paths = new ArrayList<>();

        for(int i=0;i<n;i++)
            paths.add(new ArrayList<>());

        for(int[] edge: edges){
            paths.get(edge[0]).add(new int[]{edge[1], edge[2]});
            paths.get(edge[1]).add(new int[]{edge[0], 2*edge[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
    
        pq.offer(new int[]{0,0});
        
        while(!pq.isEmpty()){
            int[] poll = pq.poll();

            if(poll[0] == n-1)
                return poll[1];

            for(int[] path: paths.get(poll[0])){
                if(path[1] + poll[1] < dist[path[0]]){
                    dist[path[0]] = poll[1] + path[1];
                    pq.offer(new int[]{path[0], dist[path[0]]});
                }
            }
        }
        return -1;

        

    }
}