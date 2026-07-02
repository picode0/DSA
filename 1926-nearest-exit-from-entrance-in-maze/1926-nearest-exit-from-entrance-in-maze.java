class Solution {
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> bfsQueue = new LinkedList<>();

        bfsQueue.offer(new int[]{entrance[0], entrance[1]});
        int steps = 1;

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[entrance[0]][entrance[1]] = true;
        while(!bfsQueue.isEmpty()){
            int size = bfsQueue.size();
            for(int i=0;i<size;i++){
                int[] coord = bfsQueue.poll();
                
                for(int j=0;j<dir.length;j++){
                    int newx = coord[0] + dir[j][0];
                    int newy = coord[1] + dir[j][1];

                    if(newx < 0 || newx >=maze.length || newy <0 || newy >=maze[0].length)
                        continue;
                    if(!visited[newx][newy] && maze[newx][newy] == '.'){
                        if(newx==0 || newx== maze.length-1 || newy == 0 || newy == maze[0].length-1)
                            return steps;
                        bfsQueue.offer(new int[]{newx, newy});
                        visited[newx][newy] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }

}