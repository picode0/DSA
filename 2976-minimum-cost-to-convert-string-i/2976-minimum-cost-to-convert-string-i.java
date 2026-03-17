class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        
        long[][] convCost = new long[26][26];

        for(long[] row:convCost)
            Arrays.fill(row, Integer.MAX_VALUE);

        for(int i=0;i<original.length;i++){
            convCost[original[i]-'a'][changed[i]-'a'] = Math.min(convCost[original[i]-'a'][changed[i]-'a'], (long)cost[i]);
        }

        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                for(int k=0;k<26;k++){
                    convCost[j][k] = Math.min(convCost[j][k], convCost[j][i] + convCost[i][k]);
                }
            }
        }

        long ret = 0;
        for(int i=0;i<source.length();i++){
            int sourceIdx = source.charAt(i)-'a'; 
            int targetIdx = target.charAt(i)-'a';
            if(sourceIdx==targetIdx)
                continue;
            if(convCost[sourceIdx][targetIdx]>=Integer.MAX_VALUE)
                return -1;
            
            ret+=convCost[sourceIdx][targetIdx];
        }

        return ret; 
    }
}