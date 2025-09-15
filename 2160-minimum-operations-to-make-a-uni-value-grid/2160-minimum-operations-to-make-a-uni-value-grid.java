class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] toArr = new int[grid.length*grid[0].length];
        int idx = 0;
        int ret = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
               toArr[idx++] = grid[i][j];
            }   
        }

        Arrays.sort(toArr);

        int target = toArr[toArr.length/2];

        for(int i=0;i<toArr.length;i++){
            int diff = Math.abs(toArr[i] - target);
            if(diff % x !=0){
                return -1;
            }
            ret+= (diff/x);
        }
        return ret;
    }
}