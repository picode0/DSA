class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>(); 
        List<List<String>> ret = new ArrayList<>();
        for(String st: strs){
            int[] charcnt = new int[26];
            StringBuilder sb = new StringBuilder(); 
            for(char c: st.toCharArray())
                charcnt[c-'a']++;
            for(int i=0;i<26;i++){
                if(charcnt[i]!=0)
                    sb.append(i + "*" + charcnt[i]);
            }
            map.putIfAbsent(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(st);
            //System.out.println(sb.toString());
        }
        for(List<String> list : map.values()){
            ret.add(new ArrayList<>(list));
        }
        return ret; 

    }
}