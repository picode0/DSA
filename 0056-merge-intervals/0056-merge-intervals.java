class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int prevstart = intervals[0][0];
        int prevend = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        
        for(int i=1;i<intervals.length;i++){

            if(intervals[i][0]>prevend){
                list.add(new int[]{prevstart,prevend});
                prevstart = intervals[i][0];
                prevend = intervals[i][1];
            }
            else{
                prevend = Math.max(prevend, intervals[i][1]);
            }
        }

        list.add(new int[]{prevstart,prevend});
        int[][] ret = new int[list.size()][2];
        for(int i=0;i<ret.length;i++){
            ret[i] = list.get(i);
        }
        return ret;
    }
}
// [1,10] [2,3] [4,5] [6,7] [8,9]