class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dis = new int[grid.size()][grid.get(0).size()];
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        for(int i=0;i<grid.size();i++){
            for(int j = 0;j<grid.get(0).size();j++){
                if(grid.get(i).get(j)==1){
                    queue.offer(new int[]{i,j});
                    dis[i][j] = 0;
                }
                else    
                    dis[i][j] = -1;
            }
        }

        while(!queue.isEmpty()){
            int[] coord = queue.poll();
            int x = coord[0], y = coord[1];
            for(int j=0;j<4;j++){
                int newx = x + dir[j][0];
                int newy = y + dir[j][1];
                if(newx < 0 || newx >=grid.size() || newy < 0 || newy >=grid.get(0).size())
                    continue;
                if(dis[newx][newy] == -1){
                    queue.offer(new int[]{newx, newy});
                    dis[newx][newy] = dis[x][y]+1;
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[2]-a[2]);
        pq.offer(new int[]{0,0, dis[0][0]});

        while(!pq.isEmpty()){
            int[] coord = pq.poll();
            int x = coord[0], y = coord[1], currdis = coord[2];
            if(x==grid.size()-1 && y==grid.size()-1)
                return currdis;
            for(int i=0;i<4;i++){
                int newx = x + dir[i][0];
                int newy = y + dir[i][1];
                if(newx < 0 || newx >=grid.size() || newy < 0 || newy >=grid.get(0).size())
                    continue;
                if(dis[newx][newy] != -1){
                    pq.offer(new int[]{newx, newy, Math.min(dis[newx][newy], currdis)});
                    dis[newx][newy] = -1;
                }
            }
        }
        return 0;
    }
}