class Solution {
    public int[] distanceToCycle(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        Set<Integer> cycleList = new HashSet<>();
        dfs(list, 0, -1, new boolean[n], cycleList);

        int[] ret = new int[n];

        for(int node: cycleList){
            bfs(node, ret, list, cycleList, new boolean[n]);
        }

        return ret; 

    }

    public int dfs(List<List<Integer>> list, int start, int parent, boolean[] visited, Set<Integer> cycleList){
        if(visited[start])
            return start;

        visited[start] = true;

        for(int neighbour: list.get(start)){
            if(neighbour!=parent){
                int node = dfs(list, neighbour, start, visited, cycleList);
                if(node>-1){
                    cycleList.add(start);
                }

                if(node!=-1){
                    if(node==start)
                        return -2;
                    return node;        
                }
            }
        }

        return -1; 
    }

    public void bfs(int start, int[] ret, List<List<Integer>> list, Set<Integer> cycleList, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int poll = queue.poll();
                ret[poll] = level;
                for(int neighbour: list.get(poll)){
                    if(!visited[neighbour] && !cycleList.contains(neighbour)){
                        queue.add(neighbour);
                        visited[neighbour] = true;
                    }
                }

            }
            level++;
        }


    }


}