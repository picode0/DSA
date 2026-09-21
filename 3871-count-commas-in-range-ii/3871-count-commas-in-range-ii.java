class Solution {
    public long countCommas(long n) {
        long limit = 1000;
        long ret = 0;
        while(limit<=n){
            ret+= n - limit +1;

            limit *=1000;
        }
        return ret;
    }
}