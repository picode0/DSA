class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int pile: piles)
            max = Math.max(max, pile);
        int left = 1, right = max;
        while(left<right){
            int mid = left + (right-left)/2;
            if(timeTaken(piles, mid)<=h)
                right = mid;
            else
                left = mid+1;
        }
        return left;
    }
    public int timeTaken(int[] piles, int speed){
        int ret = 0;
        for(int pile:piles){
            ret+= pile/speed;
            if(pile%speed>0)
                ret++;
        }
        return ret;
    }
}