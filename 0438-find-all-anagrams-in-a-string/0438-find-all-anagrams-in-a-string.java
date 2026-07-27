class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ret = new ArrayList<>();
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for(char c: p.toCharArray())
            pCount[c-'a']++;

        int left = 0;
        for(int right=0;right<s.length();right++){
            sCount[s.charAt(right)-'a']++;

            if(right>=p.length()){
                sCount[s.charAt(left)-'a']--;
                left++;
            }
            
            if(Arrays.equals(pCount, sCount))
                ret.add(right-p.length()+1);
        }
        return ret;
    }
}