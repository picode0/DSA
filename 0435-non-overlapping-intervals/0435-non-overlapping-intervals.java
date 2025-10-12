class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0] - b[0]);
        //[1,3][1,2][2,3][3,4]

        int prevend = intervals[0][1];
        int ret = 0;

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] >=prevend){
                prevend = intervals[i][1];
            }
            else{
                ret++;
                prevend = Math.min(prevend, intervals[i][1]);
            }

        }
        return ret;

    }
}