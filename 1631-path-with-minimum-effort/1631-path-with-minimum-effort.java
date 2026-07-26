class Solution {
    
    public int minimumEffortPath(int[][] heights) {
        
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            
            if(poll[0] == heights.length-1 && poll[1]==heights[0].length-1){
                return poll[2];
            }
            visited[poll[0]][poll[1]] = true;

            for(int i=0;i<dir.length;i++){
                int newx = poll[0] + dir[i][0];
                int newy = poll[1] + dir[i][1];
                if(newx>=0 && newx<heights.length && newy>=0 && newy<heights[0].length){
                    if(visited[newx][newy]){
                        continue;
                    }
                    int diff = Math.abs(heights[newx][newy]-heights[poll[0]][poll[1]]);
                    pq.offer(new int[]{newx, newy, Math.max(poll[2], diff)});
                }
            }
        }
        return 0;
    }
}