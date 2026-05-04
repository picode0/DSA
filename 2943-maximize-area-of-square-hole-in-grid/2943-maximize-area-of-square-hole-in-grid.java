class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int side = Math.min(maxStreak(hBars), maxStreak(vBars))+1;

        return side*side;
    }

    public int maxStreak(int[] bars){
        int streak = 1;
        int ret = 1;
        for(int i=1;i<bars.length;i++){
            if(bars[i] - bars[i-1]==1)
                streak++;
            else
                streak = 1;

            ret = Math.max(ret, streak);
        }
        return ret;
    }
}