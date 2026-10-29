class Solution {
    public int maximumLengthSubstring(String s) {
        int[] charFreq = new int[26];
        int left = 0, ret = 0;
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            charFreq[c-'a']++;
            while(charFreq[c-'a'] > 2){
                charFreq[s.charAt(left++)-'a']--;
            }
            ret = Math.max(ret, right-left+1);
        }
        return ret;
    }
}