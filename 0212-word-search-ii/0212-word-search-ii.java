class Solution {

    class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        String word;
        TrieNode(){}
    }
    
    List<String> ret = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode node = root;
            for(char ch: word.toCharArray()){
                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
            }
            node.word = word;
        }

        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                backtrack(board, r, c, root);
            }
        }
        return ret;
    }

    public void backtrack(char[][] board, int r, int c, TrieNode node){

        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        char ch = board[r][c];

        if(!node.children.containsKey(ch))
            return;

        TrieNode next = node.children.get(ch);
        if(next.word != null){
            ret.add(next.word);
            next.word = null;
        }

        board[r][c] = '#';
        for(int i=0;i<dir.length;i++){
            int newr = r + dir[i][0];
            int newc = c + dir[i][1];
            if(newr >=0 && newr < board.length && newc >=0 && newc < board[0].length && board[newr][newc] !='#'){
                backtrack(board, newr, newc, next);
            }
        }
        board[r][c] = ch;

    }

}