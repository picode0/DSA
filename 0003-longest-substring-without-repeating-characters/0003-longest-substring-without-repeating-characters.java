class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);

            if(map.containsKey(c))
                left = Math.max(left,map.get(c) + 1);

            ans = Math.max(ans, right-left+1);
            System.out.println("right " + right + " left " + left + " " + ans);
            map.put(c, right);
        }
        return ans;
        /*
        int ret=0;
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
        */
    }
}