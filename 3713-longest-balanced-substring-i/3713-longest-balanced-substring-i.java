class Solution {
    public int longestBalanced(String s) {
        //int[] charcnt = new int[26];
        int ret = 0;
        for(int i=0;i<s.length();i++){
            int[] charcnt = new int[26];
            for(int j=i;j<s.length();j++){
                int charidx = s.charAt(j)-'a';
                int currcnt = ++charcnt[charidx];

                boolean flag = true;
                for(int k=0;k<26;k++){
                    if(charcnt[k]!=0 && charcnt[k]!=currcnt){
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    ret = Math.max(ret, j-i+1);
            }
        }

        return ret;
    }
}