class Solution {
    public int minMoves(String[] matrix) {
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {-1,0},{1,0}};
        char[][] grid = new char[matrix.length][matrix[0].length()];
        Map<Character, List<int[]>> characterPos = new HashMap<>();
        if(matrix[grid.length-1].charAt(grid[0].length-1)=='#')
            return -1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length();j++){
                grid[i][j] = matrix[i].charAt(j);
                if(Character.isLetter(matrix[i].charAt(j))){
                    characterPos.putIfAbsent(matrix[i].charAt(j), new ArrayList<>());
                    characterPos.get(matrix[i].charAt(j)).add(new int[]{i,j});
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>(); 
        queue.offer(new int[]{0,0});
        

        if(grid[0][0] != '.' && grid[0][0]!='#'){
            for(int[] coord: characterPos.get(grid[0][0])){
                grid[coord[0]][coord[1]] = '#';
                queue.offer(coord);
            }
        }
        else{
            queue.offer(new int[]{0,0});
            grid[0][0] = '#';
        }

        if(grid[grid.length-1][grid[0].length-1]=='#')
            return 0;

        int ret = 1;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                int[] poll = queue.poll();
                for(int[] dir: dirs){
                    int newi = poll[0] + dir[0];
                    int newj = poll[1] + dir[1];
                    if(newi>=0 && newi<grid.length && newj>=0 && newj<grid[0].length && grid[newi][newj]!='#'){
                        if(grid[newi][newj]=='.'){
                            if(newi == grid.length-1 && newj == grid[0].length-1)
                                return ret;
                            grid[newi][newj] = '#';
                            queue.offer(new int[]{newi, newj});
                        }
                        else{
                            //System.out.println("i " + newi + " j" + newj + " " + grid[newi][newj]);
                            for(int[] coord: characterPos.get(grid[newi][newj])){
                                if(coord[0]==grid.length-1 && coord[1]==grid[0].length-1)
                                    return ret;
                                if(grid[coord[0]][coord[1]]!='#'){
                                    queue.offer(coord);
                                    grid[coord[0]][coord[1]] = '#';              
                                }
                            }
                        }
                    }
                }
            }
            ret++;
        }
        return -1;



    }
}