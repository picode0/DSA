class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long sum = (long)n*(n+1)/2;

        int[] ret = new int[n];

        if(target>sum || target<-sum || (sum-target)%2==1)
            return new int[]{};

        long toBeNegated = (sum-target)/2;
 
        int left = 0, right = n-1;
        for(int i=n;i>=1;i--){
            if(i<=toBeNegated){
                ret[left++] = -i;
                toBeNegated -=i;
            }
            else{
                ret[right--] = i;
            }
        }
        return ret; 

        // -2 1 3
        //  1 2 3  -> 6  target-> 0 tobeNegated -> 0 
        //  -3 1 2    


    }
}