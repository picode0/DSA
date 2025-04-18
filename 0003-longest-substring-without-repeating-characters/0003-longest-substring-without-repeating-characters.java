class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ret=0;
        //Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int left = 0 ;
        for(int right=0;right<s.length();right++){
            if(set.contains(s.charAt(right))){
                while(s.charAt(left) != s.charAt(right)){
                    set.remove(s.charAt(left++));
                }
                left++;
                //System.out.println("left " + left);
            }
            else{
                set.add(s.charAt(right));
                ret = Math.max(ret, right-left+1);
            }
        }
        return ret;
    }
}