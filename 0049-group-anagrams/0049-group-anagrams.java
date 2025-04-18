class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ret = new ArrayList<>();
        for(String str: strs){
            StringBuilder sb = new StringBuilder();
            int[] charcnt = new int[26];
            for(Character c : str.toCharArray()){
                charcnt[c-'a']++;
            }
            for(int i=0;i<26;i++){
                if(charcnt[i]>0){
                    String temp = i + " " + charcnt[i] + "*";
                    sb.append(temp);
                }
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(str);
            map.put(sb.toString(), list);
        }

        for(Map.Entry<String, List<String>> ent: map.entrySet()){
            ret.add(ent.getValue());
        }
        return ret;

    }
}