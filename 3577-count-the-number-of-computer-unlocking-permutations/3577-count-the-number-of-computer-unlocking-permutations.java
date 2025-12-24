class Solution {
    public int countPermutations(int[] complexity) {
        int minCom = complexity[0];
        int mod = 1000000007;
        for(int i=1;i<complexity.length;i++){
            if(complexity[i]<=minCom)
                return 0;
        }
        
        long ret = 1;
        for(int i=2;i<complexity.length;i++){
            ret = (ret*i)%mod;
        }
        return (int)ret;

    }
}