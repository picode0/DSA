class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obsets = new HashSet<>();
        int ret = 0;
        for(int[] obstacle:obstacles)
            obsets.add(obstacle[0] + "#" + obstacle[1]);

        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int[] currloc = new int[]{0,0};
        int currdir = 0;

        for(int command:commands){
            if(command==-1){
                currdir = (currdir + 1)%4;
                continue;
            }
            if(command==-2){
                currdir = (currdir+3)%4;
                continue;
            }
            for(int step = 0;step<command;step++){
                int newx = currloc[0]+directions[currdir][0];
                int newy = currloc[1]+directions[currdir][1];
                if(obsets.contains(newx + "#" +newy))
                    break;
                currloc = new int[]{newx, newy};
                ret = Math.max(ret, newx*newx + newy*newy);
            }
        }
        return ret;
    }

}