class Solution {
    public int minimumArea(int[][] grid) {
        int left = grid[0].length, right = -1, top = grid.length, bottom = -1;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                }
            }
        }

        return (right-left+1)*(bottom-top+1);
    }
}