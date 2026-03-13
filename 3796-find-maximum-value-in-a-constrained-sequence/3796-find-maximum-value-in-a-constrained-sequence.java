class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        long[] ret = new long[n];

        Arrays.fill(ret, Integer.MAX_VALUE);

        ret[0] = 0;

        for(int[] restriction: restrictions){
            ret[restriction[0]] = (long)restriction[1];
        }

        for(int i=1;i<n;i++){
            ret[i] = Math.min(ret[i], ret[i-1] + (long)diff[i-1]);
        }

        long retVal = ret[n-1];

        for(int i=n-2;i>=0;i--){
            ret[i] = Math.min(ret[i], ret[i+1] + diff[i]);
            retVal = Math.max(retVal, ret[i]);
        }
        return (int)retVal;

    }
}