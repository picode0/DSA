class Solution {
    public long maxMatrixSum(int[][] matrix) {
        // -1 0 -1
        // -2 1 3
        //  3 2 2
      
        long totalSum = 0L;
        //long maxNeg = Long.MIN_VALUE;
        long minAbs = Long.MAX_VALUE;
        int negCount = 0;
        //boolean zeroExists = false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){

                if(matrix[i][j] < 0){
                    negCount++;
                }
                int abs = Math.abs(matrix[i][j]);
                minAbs = Math.min(minAbs, abs);
                totalSum += abs;
            }
        }
        //System.out.println(totalSum);

        if(negCount%2==1){
            totalSum-= 2*minAbs;
        }
        return totalSum;
    }
}