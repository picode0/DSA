class Solution {
    public int lengthAfterTransformations(String s, int t) {
        // aabc xyz
        // bbcd yzab
        // ccde zabbc
        //cur 0
        // a2 b1 c1 x1 y1 z1
        // a3 b1 c1 x1 y1 z1
        // 

        int MOD = 1000000007;
        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }

        for(int i=0;i<t;i++){
            int[] newFreq = new int[26];

            for(int j=0;j<26;j++){
                if(j==0)
                    newFreq[j] = freq[25];
                else if(j==1)
                    newFreq[j] = (freq[25] + freq[j-1])%MOD;
                else
                    newFreq[j] = freq[j-1];
            }

            freq = newFreq;
        }
        int ret =0;
        for(int f : freq)
            ret= (ret + f)%MOD;

        return ret;

    }
}