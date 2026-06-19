class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length+1;

        List<List<Integer>> edgemap = new ArrayList<>();

        for(int i=0;i<n;i++)
            edgemap.add(new ArrayList<>());

        for(int[] edge: edges){
            edgemap.get(edge[0]-1).add(edge[1]-1);
            edgemap.get(edge[1]-1).add(edge[0]-1);
        }

        int maxDepth = dfs(edgemap, 0, -1);
        ///System.out.println(maxDepth);
        long ret = 1;
        for(int i=0;i<maxDepth-1;i++)
            ret = (ret * 2)%1000000007;
        
        return (int)ret; 
    }

    public int dfs(List<List<Integer>> edgemap, int node, int parent){
        int depth = 0;

        for(int child: edgemap.get(node)){
            if(child!=parent)
                depth = Math.max(depth, 1+ dfs(edgemap, child, node));
        }
        return depth;
    }
}