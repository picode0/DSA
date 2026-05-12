class Solution {
    public int minOperations(String s) {
        
        int zeroStart = 0, oneStart = 0;

        for(int i=0;i<s.length();i++){
            if(i%2==0){
                if(s.charAt(i)=='1')
                    zeroStart++;
                else    
                    oneStart++;
            }
            else{
                if(s.charAt(i)=='1')
                    oneStart++;
                else
                    zeroStart++;
            }
        }
        return Math.min(zeroStart, oneStart);
    }
}