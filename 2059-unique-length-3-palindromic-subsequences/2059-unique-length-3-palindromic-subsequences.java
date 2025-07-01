class Solution {
    public int countPalindromicSubsequence(String s) {
        //int[] prefix = new int[s.length()];
        Map<Character, List<Integer>> map = new HashMap<>();
        int ret= 0;
        List<Integer> first = new ArrayList<>();
        first.add(0);
        map.put(s.charAt(0), first);
        //prefix[0] = 1;

        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            List<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }

        for(List<Integer> ent: map.values()){
            if(ent.size()>=2){
                Set<Character> set = new HashSet<>();
                for(int i=ent.get(0)+1;i<ent.get(ent.size()-1);i++){
                    set.add(s.charAt(i));
                }
                ret+=set.size();
            }
        }

        return ret;

    }
}