class Solution {
    public int minFlips(String s) {
        String newS = s + s;
        int n = s.length();
        int diff1 =0;
        int ret = Integer.MAX_VALUE;
        for(int i=0;i<newS.length();i++){
            char c = newS.charAt(i);

            char expected1 = i%2==0?'0':'1';
            //char expected2 = i%2==0?'1':'0';

            if(c!=expected1)
                diff1++;
            
            if(i>=n){
                int leftIdx = i-n;

                char oldexpected1 = leftIdx%2==0?'0':'1';
                //char oldexpected2 = leftIdx%2==0?'1':'0';
                if(newS.charAt(leftIdx)!=oldexpected1)
                    diff1--;
            

            }
            int diff2 = n - diff1;

            if(i>=n-1)
                ret = Math.min(ret, Math.min(diff1, diff2));
            // 01001001101 01001001101
            // 01010101010 1
        }
        return ret;
    }
}