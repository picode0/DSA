class Solution {
    List<List<Integer>> adjList;
    public boolean validTree(int n, int[][] edges) {
        adjList = new ArrayList<>();

        if(edges.length!=n-1)
            return false;
            
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> seen = new HashSet<>();
        dfs(0, seen);
        return seen.size() == n;

    }

    public void dfs(int node, Set<Integer> seen){
        if(seen.contains(node))
            return;

        seen.add(node);

        for(int neighbor: adjList.get(node)){
            dfs(neighbor, seen);
        }
    }
}