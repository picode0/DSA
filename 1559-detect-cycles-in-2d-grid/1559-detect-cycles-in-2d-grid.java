class Solution {
    
    public boolean containsCycle(char[][] grid) {
        // b a c
        // c a c
        // d d c
        // b c c
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j]){
                    if(bfs(grid, visited, i, j)){
                        //System.out.println( " i j " + i + " " + j);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean bfs(char[][] grid, boolean[][] visited, int row, int col){
        //visited[row][col] = true;
        int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col, -2, -2});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            if(visited[poll[0]][poll[1]])
                return true;
            visited[poll[0]][poll[1]] = true;
            //System.out.println("curr " + poll[0] + " " + poll[1]);
            for(int[] dir:dirs){
                int newRow = poll[0] + dir[0];
                int newCol = poll[1] + dir[1];
                if(newRow>=0 && newRow < grid.length && newCol>=0 && newCol < grid[0].length && (newRow!=poll[2] || newCol!=poll[3]) && grid[newRow][newCol] == grid[poll[0]][poll[1]]) {
                    queue.offer(new int[]{newRow, newCol, poll[0], poll[1]});
                    //System.out.println("offering " + newRow + " " + newCol + " from " + poll[0] + " " + poll[1]);
                }
            }

        }

        return false; 

    }


}