class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int ret = Integer.MAX_VALUE;
        for(int[] point: points){
            map.putIfAbsent(point[0], new HashSet<>());
            map.get(point[0]).add(point[1]);
        }

        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int firstX = points[i][0];
                int firstY = points[i][1];
                int secondX = points[j][0];
                int secondY = points[j][1];

                if(firstX!=secondX && firstY!=secondY){
                    boolean checkFirst = map.get(firstX).contains(secondY);
                    boolean checkSecond = map.get(secondX).contains(firstY);
                    if(checkFirst && checkSecond){
                        int area = Math.abs(secondX-firstX)*Math.abs(secondY-firstY);
                        ret = Math.min(ret, area);
                    }
                }
            }
        }

        return ret==Integer.MAX_VALUE?0:ret;
    }
}