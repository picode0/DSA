class Solution {
    public boolean isSubsequence(String s, String t) {
        int sidx = 0, tidx = 0;
        int cnt = 0;
        if(s.equals(""))
            return true;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)==s.charAt(sidx)){
                sidx++;
                if(++cnt==s.length())
                    return true;
            }
        }
        return false;
    }
}