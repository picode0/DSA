class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> match = new HashSet<>();
        Map<String,String> caseMap = new HashMap<>();
        Map<String,String> vowelMap = new HashMap<>();
        String[] ret = new String[queries.length];

        for(String st: wordlist){
            match.add(st);
            String toLow = st.toLowerCase();
            caseMap.putIfAbsent(toLow, st);
            vowelMap.putIfAbsent(convertV(toLow), st);
        }

        for(int i=0;i<ret.length;i++){
            if(match.contains(queries[i])){
                ret[i] = queries[i];
                continue;
            }
            if(caseMap.containsKey(queries[i].toLowerCase())){
                ret[i] = caseMap.get(queries[i].toLowerCase());
                continue;
            }
            if(vowelMap.containsKey(convertV(queries[i].toLowerCase()))){
                ret[i] = vowelMap.get(convertV(queries[i].toLowerCase()));
                continue;
            }
            ret[i] = "";
        }
        return ret;
    }

    public String convertV(String word){
        StringBuilder sb = new StringBuilder();

        
        for(char c: word.toCharArray()){
            
            if(c=='i' || c=='e' || c=='o' || c=='u' || c=='a'){
                sb.append("*");
            }
            else    
                sb.append(c);
        }

        return sb.toString();
    }
}