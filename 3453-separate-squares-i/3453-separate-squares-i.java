class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double maxY = Double.MIN_VALUE;

        for(int[] square: squares){
            totalArea += (double)square[2]*square[2];
            maxY = Math.max(maxY, (double)(square[1]+square[2]));
        }

        double left = 0, right = maxY;
        double eps = 1e-5;

        while(right-left>eps){
            double mid = left + (right-left)/2;

            double areaBelow = belowLine(squares, mid);
            if(areaBelow >= totalArea/2){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        return left;

    }
    public double belowLine(int[][] squares, double y){
        double ret = 0;

        for(int[] square: squares){
            if(square[1] < y){
               ret+= (double)(square[2] * Math.min(square[2], y-square[1])); 
            }
        }

        return ret;
    }
}