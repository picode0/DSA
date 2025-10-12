class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //int[][] ret = new int[image.length][image[0].length];
        if(image[sr][sc] != color)
            dfs(image, sr, sc, image[sr][sc], color);

        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int original, int color){
        
        if(image[sr][sc]==original){
            image[sr][sc] = color;
        
            for(int i=0;i<4;i++){
                int newsr = sr + dir[i][0];
                int newsc = sc + dir[i][1];
                //System.out.println(" sr " + newsr + " sc " + newsc);
             //System.out.println(" srl " + image.length + " scl " + image[0].length);
                if(newsr>=0 && newsr<image.length && newsc >=0 && newsc<image[0].length)
                    dfs(image, newsr, newsc, original,color);
            }
        }
        // [0,0,0]
        // [0,0,0]

    }
}