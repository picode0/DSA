class Solution {
    public String smallestPalindrome(String s) {
        // 'babab' 'aabbb'
        // 'daccad' ' acd cad' ' acddca'
        /*
        int half = s.length()/2;
        char[] sToChar = s.toCharArray();
        Arrays.sort(sToChar, 0, half);

        for(int i=0;i<s.length();i++)
            sToChar[s.length()-1-i] = sToChar[i];

        return new String(sToChar);
        */
        int[] charcnt = new int[26];

        for(char c: s.toCharArray()){
            charcnt[c-'a']++;
        }

        char[] retStr = new char[s.length()];
        int leftidx = 0, rightidx = s.length()-1;
        for(int i=0;i<26;i++){
            while(charcnt[i]>0){
                char c = (char)(i+'a');
                if(charcnt[i]==1)
                    retStr[s.length()/2] = c;
                else{
                    retStr[leftidx++] = c;
                    retStr[rightidx--] = c;
                }
                charcnt[i]-=2;
            }
        }
        return new String(retStr);
    }
}