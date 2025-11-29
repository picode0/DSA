class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int[] lens = new int[words.length];

        //Map<Character,Integer> charCnt = new HashMap<>();
        int[] charCnt = new int[26];
        int i = 0;
        for(String word: words){
            lens[i++] = word.length();
            for(char c: word.toCharArray())
                charCnt[c-'a']++; 
        }
        int numPairs = 0, numSingles = 0;

        for(int j=0;j<26;j++){
            numPairs += charCnt[j]/2;
            if(charCnt[j]%2==1)
                numSingles++;
        }

        Arrays.sort(lens);
        int ret = 0;
        for(int j=0;j<lens.length;j++){
            numPairs -= lens[j]/2;
            if(lens[j]%2==1){
                if(numSingles>0)
                    numSingles--;
                else{
                    numPairs--;
                    numSingles++;
                }
            }
            if(numPairs<0)
                return ret;
            ret++;
        }
        return ret;

    }
}