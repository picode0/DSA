class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public boolean exist(char[][] board, String word) {

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(helper(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, int x, int y, int idx, String word){
        if(idx==word.length())
            return true;
        if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]!= '*' && board[x][y]==word.charAt(idx) ){
            board[x][y] = '*';
            for(int i=0;i<4;i++){
                int newx = x+dirs[i][0];
                int newy = y+dirs[i][1];
                if(helper(board, newx, newy, idx+1, word))
                    return true;
            }
            board[x][y] = word.charAt(idx);
            return false;
        }
        else
            return false;
    }

}