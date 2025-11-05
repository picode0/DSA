class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);

        int ret = 0;
        for(int i=0;i<points.length;i++){
            int upperY = points[i][1];
            int lowerY = Integer.MIN_VALUE;
            for(int j=i+1;j<points.length;j++){
                int currY = points[j][1];
                if(upperY>=currY && currY>lowerY){
                    ret++;
                    lowerY = currY;
                }
            }
        }
        return ret;
    }
}