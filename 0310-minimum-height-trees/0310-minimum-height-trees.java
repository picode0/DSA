class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if(n==1)
            return Collections.singletonList(0);
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indegree[i]==1)
                queue.offer(i);
        }

        int remaining = n;
        while(remaining >2){
            int size = queue.size();
            remaining -=size;
            for(int i=0;i<size;i++){
                int node = queue.poll();
                for(int neighbor : adjList.get(node)){
                    if(--indegree[neighbor] == 1)
                        queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<>(queue);


    }
}