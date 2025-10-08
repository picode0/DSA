class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int ret= 0;
        for(int i =0;i<words.length;i++){
            String st = words[i];
            for(int j=i+1;j<words.length;j++){
                String st2 = words[j];
                if( st2.startsWith(st) && st2.endsWith(st)){
                    ret++;
                }
            }
        }
        return ret;
    }
}