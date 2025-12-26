class Solution {
    public int maxOperations(String s) {
        // 0 1 0 1 1 0 1 1 1 0 1
        int numOnes = 0;
        int ret = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
                numOnes++;
            else{
                if(i>0 && s.charAt(i-1)!='0')
                    ret+=numOnes;
            }
        }
        return ret; 

    }
}