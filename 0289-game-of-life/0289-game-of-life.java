class Solution {
    public void gameOfLife(int[][] board) {
        int[][] dir = new int[][]{{-1,-1},{0,-1},{-1,1},{-1,0},{1,0},{1,-1},{0,1},{1,1}};

        //int[][] store = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int sum = 0;
                for(int k=0;k<dir.length;k++){
                    int newi = i+dir[k][0];
                    int newj = j+dir[k][1];
                    if(newi >=0 && newi<board.length && newj >=0 && newj <board[0].length && Math.abs(board[newi][newj])==1){
                        sum+=1;
                        //System.out.println("newi " + newi + " newj " + newj);
                    }
                }
                //System.out.println( "i " + i + " j " + j + " sum " + sum);
                if(board[i][j]==0 ){
                    if(sum==3)
                        board[i][j] = 2;
                }
                else{
                    if(sum <2 || sum >3)
                        board[i][j] = -1;
                }
            }
        }

        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 2)
                    board[i][j] = 1;
                if(board[i][j] == -1)
                    board[i][j] = 0;
            }
        }

    }
}