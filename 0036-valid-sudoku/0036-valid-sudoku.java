class Solution {
    public boolean isValidSudoku(char[][] board) {

        Map<Integer, HashSet<Character>> rowSet = new HashMap<>();
        Map<Integer, HashSet<Character>> colSet = new HashMap<>();
        Map<Integer, HashSet<Character>> boxSet = new HashMap<>();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.') continue;
                HashSet<Character> tempRowSet = rowSet.getOrDefault(i, new HashSet<Character>());
                if(tempRowSet.contains(board[i][j])){
                    //System.out.println("i " + i + " j " + j + " row ");
                    return false;
                }
                tempRowSet.add(board[i][j]);
                rowSet.put(i, tempRowSet);

                HashSet<Character> tempColSet = colSet.getOrDefault(j, new HashSet<Character>());
                if(tempColSet.contains(board[i][j])){
                    //System.out.println("i " + i + " j " + j + " col ");
                    return false;
                }
                tempColSet.add(board[i][j]);
                colSet.put(j, tempColSet);

                int boxidx = (i/3)*3 + j/3;
                HashSet<Character> tempBoxSet = boxSet.getOrDefault(boxidx, new HashSet<Character>());
                if(tempBoxSet.contains(board[i][j])){
                    //System.out.println("i " + i + " j " + j + " box ");
                    return false;
                }
                tempBoxSet.add(board[i][j]);
                boxSet.put(boxidx, tempBoxSet);
            }
        }

        return true;
    }
}