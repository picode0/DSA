class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rowIdx = new ArrayList<>();
        List<Integer> colIdx = new ArrayList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    rowIdx.add(i);
                }
            }
        }


        for(int i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[j][i]==1)
                    colIdx.add(i);
            }
        }
  
        return minDistance(rowIdx, rowIdx.get(rowIdx.size()/2)) + minDistance(colIdx, colIdx.get(colIdx.size()/2));

    }

    public int minDistance(List<Integer> idx, int origin){
        int ret = 0;

        for(int i=0;i<idx.size();i++){
            ret += Math.abs(origin-idx.get(i));
        }

        return ret;
    }
    
}