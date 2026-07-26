class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int oneCnt = 0;
        int idx = 0;

        for(char c: s.toCharArray()){
            if(c=='1')
                oneCnt++;
        }

        List<Integer> zeroBlocks = new ArrayList<>();
        while(idx < n){
            int start = idx;
            while(idx<n && s.charAt(start) == s.charAt(idx)){
                idx++;
            }
            if(s.charAt(start) == '0')
                zeroBlocks.add(idx - start);
        }
        int m = zeroBlocks.size();

        if(m<2)
            return oneCnt;

        int maxGain = 0;
        for(int i=0;i<zeroBlocks.size()-1;i++){
            maxGain = Math.max(maxGain, zeroBlocks.get(i) + zeroBlocks.get(i+1));
        }

        return maxGain + oneCnt;
    }
}