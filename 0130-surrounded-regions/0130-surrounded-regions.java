class Solution {
    int[][] dir = new int[][]{{0,1},{0,-1}, {-1,0}, {1,0}};
    public void solve(char[][] board) {
        
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            if(board[i][0] == 'O'){
                dfs(board, visited, i, 0);
            }

            if(board[i][board[0].length-1] == 'O'){
                dfs(board, visited, i, board[0].length-1);
            }
        }

        for(int j=1;j<board[0].length-1;j++){
            if(board[0][j] == 'O'){
                dfs(board, visited, 0, j);
            }

            if(board[board.length-1][j] == 'O'){
                dfs(board, visited, board.length-1, j);
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'E')
                    board[i][j] = 'O';
            }
        }



    }

    public void dfs(char[][] board, boolean[][] visited, int x, int y){
        if(visited[x][y] || board[x][y] == 'X')
            return;
        visited[x][y] = true; 
        board[x][y] = 'E';

        for(int i=0;i<4;i++){
            int newx = x + dir[i][0];
            int newy = y + dir[i][1];
            if(newx >=0 && newx < board.length && newy >=0 && newy < board[0].length){
                dfs(board, visited, newx, newy);
            }
        }

    }  
}