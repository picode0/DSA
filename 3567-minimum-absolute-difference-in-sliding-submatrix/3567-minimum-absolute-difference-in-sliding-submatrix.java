class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int[][] ret = new int[grid.length-k+1][grid[0].length-k+1];

        for(int i=0;i<=grid.length-k;i++){
            for(int j=0;j<=grid[0].length-k;j++){
                List<Integer> list = new ArrayList<>();
                for(int x=i;x<i+k;x++){
                    for(int y=j;y<j+k;y++){
                        list.add(grid[x][y]);
                    }
                }

                Collections.sort(list);
                int minval = Integer.MAX_VALUE;
                for(int z=1;z<list.size();z++){
                    if(!list.get(z).equals(list.get(z-1)))
                        minval = Math.min(minval, list.get(z)-list.get(z-1));
                }
                if(minval!=Integer.MAX_VALUE)
                    ret[i][j] = minval;
            }
        }
        return ret; 
    }
}
//  1 -2 3  
//  2  3 4