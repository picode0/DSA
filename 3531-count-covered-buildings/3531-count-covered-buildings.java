class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        List<int[]> yRange = new ArrayList<>();
        List<int[]> xRange = new ArrayList<>();
        int ret = 0;
        for(int i=0;i<=n;i++){
            yRange.add(new int[]{n+1, 0});
            xRange.add(new int[]{n+1, 0});
        }

        for(int[] building: buildings){
            int x = building[0];
            int y = building[1];
            yRange.get(x)[0] = Math.min(yRange.get(x)[0], y);
            yRange.get(x)[1] = Math.max(yRange.get(x)[1], y);
            xRange.get(y)[0] = Math.min(xRange.get(y)[0], x);
            xRange.get(y)[1] = Math.max(xRange.get(y)[1], x);

            //System.out.println(yRange.get(x)[0] + " " + yRange.get(x)[1] + " " + xRange.get(y)[0] + " " + xRange.get(y)[1]);
        }

        for(int[] building: buildings){
            int x = building[0];
            int y = building[1];
            if(x>xRange.get(y)[0] && x<xRange.get(y)[1] && y>yRange.get(x)[0] && y<yRange.get(x)[1])
                ret++;
        }

        return ret; 
    }
}