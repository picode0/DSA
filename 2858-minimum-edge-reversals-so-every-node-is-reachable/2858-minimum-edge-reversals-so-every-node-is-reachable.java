class Solution {
    Map<Integer, List<int[]>> map;
    public int[] minEdgeReversals(int n, int[][] edges) {
        map = new HashMap<>();
        for(int[] edge: edges){
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(new int[]{edge[1], 0});
            map.get(edge[1]).add(new int[]{edge[0], 1});
        }

        int[] dp = new int[n];
        dp[0] = dfs1(0, -1);

        //int[] ret = new int[n];
        dfs2(0, -1, dp);
        //System.out.println(dp[0]);
        return dp;

    }

    public int dfs1(int node, int parent){
        int ret = 0;
        for(int[] edge: map.get(node)){
            if(edge[0] != parent){
                ret+= dfs1(edge[0], node)+edge[1];
            }
        }
        return ret;
    }

    public void dfs2(int node, int parent, int[] dp){
        for(int[] edge: map.get(node)){
            if(edge[0]!=parent){
                dp[edge[0]] = dp[node];
                if(edge[1]==0)
                    dp[edge[0]]++;
                else
                    dp[edge[0]]--;
                dfs2(edge[0], node, dp);
            }
        }
    }


}