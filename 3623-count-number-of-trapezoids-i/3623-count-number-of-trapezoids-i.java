class Solution {
    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> rowMap = new HashMap<>();
        long ret = 0;
        long sum = 0;
        //int cnt = 0;
        int mod = 1000000007;
        for(int[] point: points){
            rowMap.put(point[1], rowMap.getOrDefault(point[1], 0)+1);
        }
    
        for(int numPoints: rowMap.values()){
            long linesPossible = (long)numPoints*(numPoints-1)/2;
            ret = (ret + (sum*linesPossible)%mod)%mod;
            sum = (sum + linesPossible)%mod;
        }
        return (int)ret; 
    }

}