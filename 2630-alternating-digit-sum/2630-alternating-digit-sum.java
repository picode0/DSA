class Solution {
    public int alternateDigitSum(int n) {
        int sign = 1, sum1 =0, sum2=0;
        while(n>0){
            int num = n%10;
            sum1 += (num*sign);
            sum2 += (num*sign*-1);
            n/=10;
            sign*=-1;
        }
        return sign>0?sum2:sum1;
    }
}