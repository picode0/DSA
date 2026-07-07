class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        int[] outdegree = new int[graph.length];
        for(int i=0;i<graph.length;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<graph.length;i++){
            for(int node: graph[i]){
                adj.get(node).add(i);
                outdegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<graph.length;i++)
            if(outdegree[i]==0)
                queue.add(i);
        boolean[] isSafe = new boolean[graph.length];
        while(!queue.isEmpty()){
            int safe = queue.poll();
            isSafe[safe] = true;
            for(int nextNode: adj.get(safe)){
                if(--outdegree[nextNode] ==0)
                    queue.offer(nextNode);
            }
        }

        for(int i=0;i<graph.length;i++){
            if(isSafe[i])
                ret.add(i);
        }
        return ret;


        /*
        int nodeCount = graph.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nodeCount;i++){
            if(isSafe(graph, i, new boolean[nodeCount], new boolean[nodeCount]))
                list.add(i);
        }
        return list;
        */
    }
    /*

    public boolean isSafe(int[][] graph, int node, boolean[] visited, boolean[] curr){
       
        if(curr[node])
            return false;
        
        if(visited[node])
            return true;
            
        visited[node] = true;
        curr[node] = true;
        for(int i=0;i<graph[node].length;i++){
            if(!isSafe(graph, graph[node][i], visited, curr))
                return false;
        }
        curr[node] = false;
        return true;
    }
    */
}