class Solution {
    public int minDeletionSize(String[] strs) {
        // cay bbx acz
        // T  T  f
        // xc yb za
        // F  F

        // ac ab ca
        // F  T
        int n = strs.length;
        int m = strs[0].length();

        boolean[] sorted = new boolean[n-1];
        int ret = 0;
        for(int col=0;col<m;col++){
            boolean needDelete = false;
            for(int row =0;row<n-1;row++){
                if(!sorted[row] && strs[row].charAt(col) > strs[row+1].charAt(col)){
                    needDelete = true;
                    break;
                }
            }
            if(needDelete){
                ret++;
                continue;
            }
            else{
                for(int row=0;row<n-1;row++){
                    if(strs[row].charAt(col) < strs[row+1].charAt(col)){
                        sorted[row] = true;
                    }
                }
            }
        }
        return ret;
    }
}