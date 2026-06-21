class Solution {
    int[][] dir = new int[][]{{-1, 0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0]==1)
            return -1;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});

        int ret = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] poll = queue.poll();
                if(poll[0]==grid.length-1 && poll[1] == grid[0].length-1)
                    return ret;
                for(int j=0;j<dir.length;j++){
                    int newx = poll[0] + dir[j][0];
                    int newy = poll[1] + dir[j][1];
                    if(newx >=0 && newx < grid.length && newy >=0 && newy < grid[0].length && !visited[newx][newy] && grid[newx][newy]==0){
                        queue.offer(new int[]{newx, newy});
                        visited[newx][newy] = true;
                    }
                }
            }
            ret++;
        }
        return -1;
        // 1 0 0
        // 1 1 0
        // 1 1 0 
    }
}