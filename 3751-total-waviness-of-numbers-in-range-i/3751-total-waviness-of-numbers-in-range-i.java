class Solution {
    public int totalWaviness(int num1, int num2) {
        int ret = 0;
        for(int num = num1;num<=num2;num++){
            ret+=countPV(num);
        }   
        return ret;
    }

    public int countPV(int n){
        String nToSt = n+ "";
        int ret  = 0;
        for(int i=1;i<nToSt.length()-1;i++){
            int curr = nToSt.charAt(i)-'0';
            int prev = nToSt.charAt(i-1)-'0';
            int next = nToSt.charAt(i+1)-'0';
            boolean isPeak = curr>prev && curr>next;
            boolean isValley = curr<prev && curr<next;
            if(isPeak || isValley)
                ret++;
        }
        return ret;
    }
}