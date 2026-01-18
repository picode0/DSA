class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int ret = 0;
        for(int i=0;i<grid.length-2;i++){
            for(int j=0;j<grid[0].length-2;j++){
                if(isMagic(grid, i,j))
                 ret++;
            }
        }
        return ret;
    }

    public boolean isMagic(int[][] grid, int row, int col){
        boolean[] visited = new boolean[10];

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int num = grid[row+i][col+j];
                if(num<1 || num>9 || visited[num])
                    return false;
                visited[num] = true;
            }
        }

        int sum = grid[row][col] + grid[row][col+1] + grid[row][col+2];

        int row2 = grid[row+1][col] + grid[row+1][col+1] + grid[row+1][col+2];

        int row3 = grid[row+2][col] + grid[row+2][col+1] + grid[row+2][col+2];

        if(!(sum==row2 && sum==row3))
            return false;

        for(int i=0;i<3;i++){
            if(grid[row][col+i] + grid[row+1][col+i] + grid[row+2][col+i] != sum)
                return false;
        }

        int diag1 = grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2];
        int diag2 = grid[row+2][col] + grid[row+1][col+1] + grid[row][col+2];

        if(!(sum==diag1 && sum==diag2))
            return false;

        return true;

    }
}