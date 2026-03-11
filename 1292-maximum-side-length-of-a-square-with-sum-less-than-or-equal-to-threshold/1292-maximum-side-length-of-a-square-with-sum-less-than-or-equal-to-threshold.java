class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int[][] prefix = new int[mat.length+1][mat[0].length+1];

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                prefix[i+1][j+1] = mat[i][j] + prefix[i+1][j] + prefix[i][j+1] - prefix[i][j];  
            }
        }

        int left = 0, right = Math.min(mat.length, mat[0].length);

        while(left<right){
            int mid = left + (right-left)/2 + 1;
            if(squareExists(prefix, mid, threshold)){
                //System.out.println("exissts " + mid);
                left = mid;
            }
            else
                right = mid - 1;
        }
        return left;
    }

    public boolean squareExists(int[][] prefix, int sideLen, int threshold){
        for(int i=sideLen;i<prefix.length;i++){
            for(int j=sideLen;j<prefix[0].length;j++){
                int squareSum = prefix[i][j] - prefix[i-sideLen][j] - prefix[i][j-sideLen] + prefix[i-sideLen][j-sideLen];
                if(squareSum<=threshold)
                    return true;
            }
        }
        return false;
    }
}