class Solution {
    public int numSub(String s) {
        int mod = 1000000007;
        long cnt = 0;
        long ret = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
                cnt++;
            else{
                ret+= (cnt*(cnt+1)/2);
                ret%=mod;
                cnt = 0;
            }
        }
 
        ret+= (cnt*(cnt+1)/2);
        ret%=mod;

        return (int)ret;
    }
}