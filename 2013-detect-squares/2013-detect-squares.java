class DetectSquares {
    Map<String,Integer> coordMap;
    public DetectSquares() {
        coordMap = new HashMap<>();
    }
    
    public void add(int[] point) {
        String coord = point[0] + "#" + point[1];
        coordMap.put(coord, coordMap.getOrDefault(coord, 0)+1);
    }
    
    public int count(int[] point) {
        int ret = 0;
        int currX = point[0];
        int currY = point[1];
        String currCoord = point[0]+"#"+point[1];
        for(Map.Entry<String,Integer> ent: coordMap.entrySet()){
            //System.out.println(ent.getKey() + " key");
            if(ent.getKey().equals(currCoord)) continue;
            String[] split = ent.getKey().split("#");
            int xcoord = Integer.valueOf(split[0]);
            int ycoord = Integer.valueOf(split[1]);
            if(Math.abs(currY-ycoord) == Math.abs(currX-xcoord)){
                //System.out.println("found " + xcoord + " " + ycoord);
                String thirdPoint = currX+"#"+ycoord;
                String fourthPoint = xcoord+"#"+currY;
                ret+=ent.getValue()*coordMap.getOrDefault(thirdPoint, 0)*coordMap.getOrDefault(fourthPoint, 0);
            }
        }
        // 419, 351   798,351   798, 730    419,730
        return ret; 
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */