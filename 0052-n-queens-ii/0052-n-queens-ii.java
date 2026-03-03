class Solution {
    public int totalNQueens(int n) {
        return backtrack(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>()); 

    }

    public int backtrack(int row, int n, Set<Integer> colset, Set<Integer> diagset, Set<Integer> antidiagset){
        if(row==n)
            return 1;

        int val=0;

        for(int i=0;i<n;i++){
            int col = i;
            int diag = row - i;
            int antidiag = row + i;
            
            if(!colset.contains(col) && !diagset.contains(diag) && !antidiagset.contains(antidiag)){
                colset.add(col);
                diagset.add(diag);;
                antidiagset.add(antidiag);
                val+=backtrack(row+1, n, colset, diagset, antidiagset);
                colset.remove(col);
                diagset.remove(diag);
                antidiagset.remove(antidiag);
            }
        }
        return val;
    }
}