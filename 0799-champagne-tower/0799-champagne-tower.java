class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] cup = new double[101][101];
        cup[0][0] = (double)poured;

        for(int i=0;i<query_row;i++){
            for(int j=0;j<=i;j++){
                double excess = (cup[i][j] -1)/2;
                if(excess>0){
                    cup[i+1][j] += excess;
                    cup[i+1][j+1] += excess;
                }
            }
        }

        return Math.min(1,cup[query_row][query_glass]);


    }
}