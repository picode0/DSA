class Solution {
    public int longestBalanced(String s) {
        int singleCount = 0;
        int cnt = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1))
                cnt++;
            else
                cnt= 1;
            singleCount = Math.max(singleCount, cnt);
        }

        int doubleCount = Math.max(Math.max(doubleCnt(s, 'a', 'b'), doubleCnt(s, 'a','c')), doubleCnt(s, 'b','c'));
        int tripleCount = tripleCnt(s, 'a', 'b', 'c');

        return Math.max(Math.max(singleCount, doubleCount), tripleCount);

    }

    public int doubleCnt(String s, char a, char b){
        Map<Integer, Integer> cntMap = new HashMap<>();

        cntMap.put(0, -1);

        int cnt = 0;
        int ret = 1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != a && s.charAt(i) != b){
                cntMap = new HashMap<>();
                cntMap.put(0, i);
                cnt = 0;
                continue;
            }
            cnt+= s.charAt(i) == a? 1:-1;
            if(cntMap.containsKey(cnt)){
                ret = Math.max(ret, i - cntMap.get(cnt));
               
            }
            else
                cntMap.put(cnt, i);
        }
        return ret; 
    }

    public int tripleCnt(String s, char a, char b, char c){
        Map<String, Integer> cntMap = new HashMap<>();
        int[] charCnt = new int[3];
        int ret = 1;
        cntMap.put("0#0", -1);

        for(int i=0;i<s.length();i++){
            charCnt[s.charAt(i)-'a']++;
            int diff1 = charCnt[0] - charCnt[1];
            int diff2 = charCnt[1] - charCnt[2];
            String key = diff1 + "#" + diff2;
            if(cntMap.containsKey(key))
                ret = Math.max(ret, i-cntMap.get(key));
            else
                cntMap.put(key, i);
        }
        return ret;
    }


}