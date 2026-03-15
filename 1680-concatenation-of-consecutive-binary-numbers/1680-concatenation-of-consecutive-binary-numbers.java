class Solution {
    public int concatenatedBinary(int n) {
        long ret = 0;
        int length = 0;
        int mod = 1000000007;
 
        for(int i=1;i<=n;i++){
            if((i&(i-1))==0){
                length++;
            }
            ret = ((ret << length) | i)%mod;
        }
        return (int)ret;
    }
}