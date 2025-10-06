class Solution {
    public int[][] candyCrush(int[][] board) {
        
        int nrows = board.length;
        int ncols = board[0].length;
        boolean keepGoing = true;

        while(keepGoing){
            keepGoing = false;
            for(int i=0;i<nrows;i++){
                for(int j=1;j<ncols-1;j++){
                    if(board[i][j]==0)
                        continue;
                    if(Math.abs(board[i][j]) == Math.abs(board[i][j-1]) && Math.abs(board[i][j]) == Math.abs(board[i][j+1])){
                        keepGoing = true;
                        int val = Math.abs(board[i][j]);
                        board[i][j] = -val;
                        board[i][j-1] = -val;
                        board[i][j+1] = -val;
                    }
                }
            }

            for(int i=0;i<ncols;i++){
                for(int j=1;j<nrows-1;j++){
                    if(board[j][i]==0)
                        continue;
                    if(Math.abs(board[j][i]) == Math.abs(board[j+1][i]) && Math.abs(board[j][i]) == Math.abs(board[j-1][i])){
                        keepGoing = true;
                        int val = Math.abs(board[j][i]);
                        board[j][i] = -val;
                        board[j-1][i] = -val;
                        board[j+1][i] = -val;
                    }
                }
            }



            if(keepGoing){
                for(int i=0;i<ncols;i++){
                    int pos = nrows-1;
                    for(int j=nrows-1;j>=0;j--){
                        if(board[j][i] > 0){
                            board[pos][i] = board[j][i];
                            pos--;
                        }
                    }
                    while(pos>=0){
                        board[pos][i] = 0;
                        pos--;
                    }
                }
            }

        }
        return board;
    }
}