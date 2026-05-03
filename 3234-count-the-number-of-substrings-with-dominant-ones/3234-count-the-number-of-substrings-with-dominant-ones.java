class Solution {
    public int numberOfSubstrings(String s) {
        
        int n = s.length();
        int[] prevZero = new int[n+1];
        int ret =0;

        //prevZero[0] = -1;
        for(int i=0;i<n;i++){
            if(i==0 || s.charAt(i-1)=='0')
                prevZero[i+1] = i;
            else
                prevZero[i+1] = prevZero[i];
        }

        for(int i=1;i<=n;i++){
            int pos = i;
            int zeroCount = s.charAt(i-1)=='0'?1:0;
            while(pos>0 && zeroCount*zeroCount <=n){
                int segLen = i - prevZero[pos];
                int oneCount = segLen - zeroCount;
                if(oneCount >= zeroCount*zeroCount){
                    int possibleLen = oneCount - zeroCount*zeroCount +1;
                    int totalLen = pos - prevZero[pos];
                    ret += Math.min(possibleLen, totalLen);
                }
                pos = prevZero[pos];
                zeroCount++;
            }
        }
        return ret;
    }
}