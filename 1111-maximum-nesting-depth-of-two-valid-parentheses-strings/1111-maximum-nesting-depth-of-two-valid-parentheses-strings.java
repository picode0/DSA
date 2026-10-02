class Solution {
    public int[] maxDepthAfterSplit(String seq) {

        int d = 0;
        int n = seq.length();
        int[] ret = new int[n];
        for(int i=0;i<n;i++){
            if(seq.charAt(i) == '('){
                d++;
                ret[i] = d%2;
            }
            else{
                ret[i] = d%2;
                d--;
            }
        }
        return ret;
    }  

    
}