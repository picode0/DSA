class Solution {
    public long minimumTime(int[] d, int[] r) {
        long left = 0, right = ((long)d[0] + d[1])*Math.max(r[0], r[1]);

        while(left<right){
            long mid = left + (right-left)/2;
            if(canFinish(d, r, mid)){
                right = mid;
            }
            else
                left = mid + 1;
        }
        return left; 
    }

    public boolean canFinish(int[] d, int[] r, long time){
        long t1 = time - time/r[0];
        long t2 = time - time/r[1];

        long lcm = (long)r[0]*r[1] / gcd(r[0], r[1]);
        long t3 = time - time/lcm;

        return t1>=d[0] && t2>=d[1] && t3>=(long)d[0] + d[1];
    }

    public long gcd(long a, long b){
        while(b!=0){
            long temp = a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}