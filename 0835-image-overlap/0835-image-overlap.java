class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
       
        int n = img1.length;
        List<int[]> onesPos1 = new ArrayList<>();
        List<int[]> onesPos2 = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(img1[i][j] == 1)
                    onesPos1.add(new int[]{i,j});
                if(img2[i][j] ==1)
                    onesPos2.add(new int[]{i,j});
            }
        }
        int maxCount = 0;
        Map<String, Integer> overlapCount = new HashMap<>();
        for(int[] A: onesPos1){
            for(int[] B: onesPos2){
                int xShift = B[0] - A[0];
                int yShift = B[1] - A[1];
                String shift = xShift + "#" + yShift;
                overlapCount.put(shift, overlapCount.getOrDefault(shift, 0)+1);
                maxCount = Math.max(maxCount, overlapCount.get(shift));
            }
        }
        return maxCount;
    }
}