class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());

        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(source);
        visited.add(source);

        while(!queue.isEmpty()){
            int poll = queue.poll();
            if(poll==destination)
                return true;
            //visited.add(poll);
            for(int next : graph.get(poll)){
                if(!visited.contains(next)){
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        return false;
    }
}