class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] rowpf = new int[m+1][n+1];
        int[][] colpf = new int[m+1][n+1];
        int[][] diagpf = new int[m+1][n+1];
        int[][] antidiagpf = new int[m+1][n+1];

        int side = Math.min(m,n);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int val = grid[i][j];

                rowpf[i+1][j+1] = rowpf[i+1][j] + val;
                colpf[i+1][j+1] = colpf[i][j+1] + val;
                diagpf[i+1][j+1] = diagpf[i][j] + val;
                antidiagpf[i+1][j] = antidiagpf[i][j+1] + val;
            }
        }

        while(side>1){
            if(isValid(side, m, n, rowpf, colpf, diagpf, antidiagpf))
                return side;

            side--;
        }

        return side;
        // 5 
    }

    public boolean isValid(int side, int m, int n, int[][] rowpf, int[][] colpf, int[][] diagpf, int[][] antidiagpf){

        for(int i=0;i<=m-side;i++){
            for(int j=0;j<=n-side;j++){
                int target = diagpf[i+side][j+side] - diagpf[i][j];
                int antidiag = antidiagpf[i+side][j] - antidiagpf[i][j+side];
                if(antidiag!=target)
                    continue;

                boolean valid = true;
                for(int k=0;k<side;k++){
                    int rowsum = rowpf[i+1+k][j+side] - rowpf[i+1+k][j];
                    int colsum = colpf[i+side][j+1+k] - colpf[i][j+1+k];

                    if(rowsum!=target || colsum!=target){
                        valid = false;
                        break;
                    }
                
                }
                if(valid)
                    return true;

            }
        }
        return false;
    }
}