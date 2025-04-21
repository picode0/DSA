class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> paths = new ArrayList<>();
        int ret = Integer.MAX_VALUE;
        for(int i=0;i<n+1;i++)
            paths.add(new ArrayList<>());
        
        for(int[] road:roads){
            List<int[]> list = paths.get(road[0]);
            List<int[]> list2 = paths.get(road[1]);
            list.add(new int[]{road[1], road[2]});
            list2.add(new int[]{road[0], road[2]});
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            for(int[] path: paths.get(poll[0])){
                ret = Math.min(ret, path[1]);
                if(!visited[path[0]]){
                    visited[path[0]] = true;
                    queue.offer(new int[]{path[0], path[1]});
                }
            }
        }
        return ret; 



        
    }
}