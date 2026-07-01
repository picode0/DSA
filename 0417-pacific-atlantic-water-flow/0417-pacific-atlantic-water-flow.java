class Solution {
    int[][] dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();

        for(int i=0;i<heights[0].length;i++){
            pacificQ.offer(new int[]{0, i});
            atlanticQ.offer(new int[]{heights.length-1, i});
        }

        for(int i=0;i<heights.length;i++){
            pacificQ.offer(new int[]{i,0});
            atlanticQ.offer(new int[]{i, heights[0].length-1});
        }

        boolean[][] canReachP = canReach(pacificQ, heights);
        boolean[][] canReachQ = canReach(atlanticQ, heights);

        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(canReachP[i][j] && canReachQ[i][j]){
                    ret.add(List.of(i,j));
                }
            }
        }
        return ret;

    }

    public boolean[][] canReach(Queue<int[]> coord, int[][] heights){
        boolean[][] ret = new boolean[heights.length][heights[0].length];
        while(!coord.isEmpty()){
            int[] poll = coord.poll();
            ret[poll[0]][poll[1]] = true;
            for(int i=0;i<dir.length;i++){
                int newx = poll[0] + dir[i][0];
                int newy = poll[1] + dir[i][1];

                if(newx>=0 && newx<heights.length && newy>=0 && newy < heights[0].length){
                    if(!ret[newx][newy] && heights[newx][newy]>=heights[poll[0]][poll[1]]){
                        coord.offer(new int[]{newx, newy});
                    }
                }

            }
        }
        return ret;
    }
}