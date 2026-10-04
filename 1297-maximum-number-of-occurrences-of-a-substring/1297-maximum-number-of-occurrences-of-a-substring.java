class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int[] freq = new int[26];
        int unique = 0;
        int left = 0;
        Map<String, Integer> subFreq = new HashMap<>();
        int ret = 0;
        for(int right = 0; right<s.length();right++){
            if(++freq[s.charAt(right)-'a']==1){
                unique++;
            }
            while(right-left+1 >= minSize && right-left+1<=maxSize){
                if(unique <= maxLetters){
                    String sub = s.substring(left,right+1);
                    subFreq.put(sub, subFreq.getOrDefault(sub, 0)+1);
                    ret = Math.max(ret, subFreq.get(sub));
                }
                if(--freq[s.charAt(left++)-'a']==0){
                    unique--;
                }
            }
        }
        return ret;
    }
}