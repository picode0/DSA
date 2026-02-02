class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character,Integer> map = new HashMap<>();
        int left=0, max =0 , ret=0;
        for(int right =0;right<s.length();right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);
            max = Math.max(max, map.get(s.charAt(right)));

            if(right-left+1 - max <=k)
                ret = Math.max(ret, right-left+1);
            else{
                map.put(s.charAt(left), map.get(s.charAt(left++))-1);
            }
        }
        return ret;
    }
}