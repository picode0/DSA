class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int ret = intervals.length;

        Arrays.sort(intervals, (a,b)->a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]);

        int prevend = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][1] <= prevend){
                ret--;
            }
            else 
                prevend = intervals[i][1];
        }
        return ret;
    }
}